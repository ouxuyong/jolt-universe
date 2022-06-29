# shift相关案例讲解
1. [简单的格式转换](#a1)  
2. [shift模式中‘&’和‘*'的简单使用](#a2)  
3. [shift模式中数组的转换和 ‘#’的使用](#a3)  
4. [shift模式中 ‘$’的使用](#a4)  
5. [shift模式中 ‘@’的使用](#a5)  

**shift 模式的作用的将一个input 的json 转成 expected的json,只改变数据结构，不对数据进行操作**
#### <a name="a1"></a>简单的格式转换
input 输入:
```json
   {
     "order": {
          "orderItem": {
             "id": 3,
             "num": 5
          }
       }
   }
   
 ```
 expected 预期输出：
   ```json
      {
        "orderForm": {
             "orderDetails": {
                "id": 3,
                "num": 5
             }
          }
      }
      
  ```
 jolt简单的表达式如下：
 ```json
[
  {
    "operation": "shift",
    "spec": {
      "order": {
        "orderItem": {
          "id": "orderForm.orderDetails.id", // 将id 为3的值复制到 "orderForm.orderDetails.id"的路径上
          "num": "orderForm.orderDetails.num" // 将num为 5的值复制到"orderForm.orderDetails.num"
        }
      }
    }
  }
]
```
#### <a name="a2"></a>shift模式中‘&’和‘*'的简单使用
'*'的用法和正则表达式中的类似，指的是模糊匹配，下面我们用具体的例子说明  
input 输入:
```json
{
  "rating": {
    "primary": {
      "value": 3
    },
    "quality": {
      "value": 3
    }
  }
}
```    
expected 预期输出:
```json
{
  "SecondaryRatings" : {
    "data_primary" : {
      "val" : 3
    },
    "data_quality" : {
      "val" : 3
    }
  }
}
```  
jolt 表达式如下:   
```json
[
  {
    "operation": "shift",
    "spec": {
      "rating": {
        "*": { //这里的‘*’匹配的是 input 中的 primary 和 quality
          "value": "SecondaryRatings.data_&1.val" // &1匹配的就是 primary 或 quality
        }
      }
    }
  }
]
```
这里我们来讲解一下‘&’的用法比如上文的表达式，&1 指的意思就是“value”上一级的key，那“value”上一级的key  
就是‘\*’，又因为“\*”匹配的是primary 和 quality,所以 &1取到的就是（primary 或 quality），同理 &2 取到的就是key “rating”  

下面我们再用更多具体的例子，让大家更深入了解“&”的用法  
下面为大家讲解如何利用将input 一个值赋值给两个key  
input 输入:
```json
{
  "rating_primary_value": 3
}
```  
expected 预期输出:
```json
{
  "key_primary" : 3,
  "key_value" : 3
}
```
jolt 表达式,这里给大家演示两种方式
```json
//方式1： 
[
  {
    "operation": "shift",
    "spec": {
    //这里数组的意思是将 rating_primary_value 的值拷贝到数组元素的key中
      "rating_primary_value": ["key_primary", "key_value"] 
    }
  }
]

//方式2：
[
  {
    "operation": "shift",
    "spec": { 
    // 第一个“*”号匹配的是"primary",第二的“*”匹配的是"value"  
    //&(0,1)指的是第一个“*”号匹配的值，&(0,2)指的是第二个星号匹配的值
      "rating_*_*": ["key_&(0,1)", "key_&(0,2)"]
    }
  }
]

//上面这个例子 &0 和&（0,0）的效果是等价的匹配到的都是 “rating_primary_value” ，&（0,1）指的就是在 "rating_*_*" 中一个*号匹配的值"primary"， 以此类推 
// &1 和 &（1,0）匹配到的是 “root”，这个后面我们的源码中会讲解

```
#### <a name="a3"></a>shift模式中数组的转换和 ‘#’的使用  
'#'的作用通常是用来转换数组的，下面我们用具体的例子讲解
input 输入:  
```json
{
    "orderId": 1212,
    "orderNo": "202223434343",
    "orderItem": [
        {
            "orderItemId": 1,
            "orderItemNo": "2022xxxxxx01",
            "goods": [
                {
                    "goodsId": 1,
                    "goodsNum": 5
                },
                {
                    "goodsId": 2,
                    "goodsNum": 6
                }
            ]
        },
        {
            "orderItemId": 2,
            "orderItemNo": "2022xxxxxx02",
            "goods": [
                {
                    "goodsId": 3,
                    "goodsNum": 6
                },
                {
                    "goodsId": 4,
                    "goodsNum": 7
                }
            ]
        }
    ]
}
```  
shift :  
```json
[{
	"operation": "shift",
	"spec": {
		"orderId": "o_id",
		"orderNo": "o_no",
		"orderItem": {
			"*": { // '*' 匹配的是orderItem数组的下标
				"orderItemId": "o_item.[#2].o_item_id", // #2代表的是从orderItemId往上数的第二个key,也就是'orderItem',这就代表着 o_item数组对标 输入的 orderItem
				"orderItemNo": "o_item.[#2].o_item_no",
				"goods": {
					"*": {
						"goodsId": "o_item.[#4].o_goods.[#2].g_id", // 这里类似 [#4] 往上数4就是'orderItem'，[#2]就是 'goods'
						"goodsNum": "o_item.[#4].o_goods.[#2].g_num"
					}
				}
			}
		}
	}
}]
```   
输出：  
```json
{
    "o_id": 1212,
    "o_no": "202223434343",
    "o_item": [
        {
            "o_item_id": 1,
            "o_item_no": "2022xxxxxx01",
            "o_goods": [
                {
                    "g_id": 1,
                    "g_num": 5
                },
                {
                    "g_id": 2,
                    "g_num": 6
                }
            ]
        },
        {
            "o_item_id": 2,
            "o_item_no": "2022xxxxxx02",
            "o_goods": [
                {
                    "g_id": 3,
                    "g_num": 6
                },
                {
                    "g_id": 4,
                    "g_num": 7
                }
            ]
        }
    ]
}
```  
如果输入的json 是一个数组要怎么转换呢，请看下面的例子  
input 输入: 
```json
[
    {
        "orderItemId": 1,
        "orderItemNo": "2022xxxxxx01"
    },
    {
        "orderItemId": 2,
        "orderItemNo": "2022xxxxxx02"
    }
]
```  
预期输出：  
```json
[ {
  "orderId" : 1,
  "orderNo" : "2022xxxxxx01"
}, {
  "orderId" : 2,
  "orderNo" : "2022xxxxxx02"
} ]

```   
spec 表达式：  
```json
[
  {
    "operation": "shift",
    "spec": {
      "*": {
        "orderItemId": "[#2].orderId",
        "orderItemNo": "[#2].orderNo"
      }
    }
  }
]
```   
其实除了使用‘#’进行数组的转换，还可以使用“&”来实现，比如上文的转换，也可以使用如下表达式   
spec 表达式：  
```json
[
  {
    "operation": "shift",
    "spec": {
      "*": {
        "orderItemId": "[&1].orderId",
        "orderItemNo": "[&1].orderNo"
      }
    }
  }
]
```   
shift 模式也支持取出指定下标的元素  
```json
{
  "order": [
    {
      "orderItemId": 1,
      "orderItemNo": "2022xxxxxx01"
    },
    {
      "orderItemId": 2,
      "orderItemNo": "2022xxxxxx02"
    }
  ]
}
```  
取出下标为0的元素 spec：  
```json
[
  {
    "operation": "shift",
    "spec": {
      "order": {
        "0": "order"
      }
    }
  }
]
```  
输出结果：  
```json
{
  "order" : {
    "orderItemId" : 1,
    "orderItemNo" : "2022xxxxxx01"
  }
}
```

‘&’转换数组和‘#’的区别在于[]里面的数值,‘&’ 比‘#’小1，  
[&]对应的是下标,如上文 * 匹配的是下标 0或 1，[&1]只的就是对应的下标0或1 
[#]要对应的是上层的key，如上文，[#2]对应的是key 'root',有小伙伴就会产生疑问这个‘root’是哪来的，input里面没有呀，别着急后续我们会在源码篇详细讲解   

**上面将的都是‘#’在LHS的用，下面我们将一下‘#’在 RHS变的用法，‘#’在RHS可以给输出key赋值指定字符串**

```json
{
  "rating": "555",
  "primary": "1234"
}
```  
spec: 
```json
[
  {
    "operation": "shift",
    "spec": {
      "rating": "rating",
      "primary": "primary",
      "#666": "value" //给value 赋值 “666”
    }
  }
]
```  
输出结果：  
```json
{
  "value" : "666",
  "rating" : "555",
  "primary" : "1234"
}
```   
基于上面的用法比较常用的转换就是枚举值的转换  
假设我们这这样一个例子，输出一个sex 字段，1代表男，2代表女，我们需要把这个字段转换成SexEnum枚举类  

```java
package com.example.oxy.enums;
import lombok.Getter;

/**
 * 性别枚举类
 * @author oxy
 */
public enum SexEnum {
    MAN("男", "man"),
    WOMAN("女", "woman");

    @Getter
    private String desc;

    @Getter
    private String code;

    SexEnum(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }
}

```   
input 输入:  
```json
{
  "name": "张三",
  "sex": 1
}
```  
shift:
```json
[
  {
    "operation": "shift",
    "spec": {
      "name": "name",
      "sex": {
        "1": { //如果sex =1 ,将其转成男性枚举值
          "#男": "sex.desc",
          "#man": "sex.code"
        },
        "2": { //如果sex =2 ,将其转成女性枚举值
          "#女": "sex.desc",
          "#woman": "sex.code"
        }
      }
    }
  }
]

```
```json
{
  "name" : "张三",
  "sex" : {
    "desc" : "男",
    "code" : "man"
  }
}
```

#### <a name="a4"></a>shift模式中 ‘$’的使用
'$'的作用是将input中的key当做值，映射给输出的json key中，请看下面的例子  
input 输入:  
```json
{
  "rating": {
    "primary": {
      "value": 3
    },
    "quality": {
      "value": 3
    }
  }
}
```  
spec：  
```json
[
  {
    "operation": "shift",
    "spec": {
      "rating": {
        "primary": {
          "value": "Rating",
          "max": "RatingRange"
        },
        "*": { //"*"匹配的是 quality
          "$": "SecondaryRatings.Id" //"$"的意思是将“*”匹配的key 当做值赋值给 SecondaryRatings.Id
        }
      }
    }
  }
]

```   
输出：  
```json
{
  "Rating" : 3,
  "SecondaryRatings" : {
    "Id" : "quality"
  }
}
```  

#### <a name="a5"></a>shift模式中 ‘@’的使用
'@' LHS、RHS都有效，意义一样,可以取到数据树中指定的值,单独写@时是等价于@0的，下面我们有具体的例子来讲解  
input 输入:  
```json
{
  "rating": {
    "primary": 111,
    "quality": 222
  },
  "xxx": 4444
}
```    
spec：  
```json
[
  {
    "operation": "shift",
    "spec": {
      "rating": {
        "@": "yyy"  //将@等价于@0，代表的是将 rating 的值赋值给yyy
      }
    }
  }
]

```  
输出：  
```json
{
  "yyy" : {
    "primary" : 111,
    "quality" : 222
  }
}
```   

input 输入:  
```json
{
  "rating": {
    "primary": 111,
    "quality": 222
  },
  "xxx": 4444
}
```   
spec：  
```json
[
  {
    "operation": "shift",
    "spec": {
      "rating": {
        "@primary": "yyy", //将@primary等价于@(0,primary)，代表的是将 primary 的值赋值给yyy
        "@quality": "aaa", //将@primary等价于@(0,quality)，代表的是将 quality 的值赋值给aaa
        "@(1,xxx)": "bbb", //@(1,xxx) 的1代表和rating同一个等级的xxx 的值赋值给 bbb
        "primary": {
          "@(2,xxx)": "ccc" //@(2,xxx)的2是'primary'指往上数2个等级的也就是和rating同一等级的xxx的值赋值给ccc
        }
      }
    }
  }
]

```  
输出：  
```json
{
  "yyy" : 111,
  "aaa" : 222,
  "bbb" : 4444,
  "ccc" : 4444
}
```  
'@'在RHS的使用例子 

input 输入:  
```json
{
  "rating": {
    "primary": "orderKey",
    "quality": "order"
  }
}
```   
spec：  
```json
[
  {
    "operation": "shift",
    "spec": {
      "rating": {
        "@primary": "@quality" //将rating.primary的值赋值给 order，order是rating.quality的值
      }
    }
  }
]

```   
输出：  
```json
{
  "order" : "orderKey"
}
```  

