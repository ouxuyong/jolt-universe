# Shift related case explanation
1. [Simple format conversion](#a1)  
2. [Simple use of '&' and '*' in shift mode](#a2)  
3. [Array transformation and use of '#' in shift mode](#a3)  
4. [Use of '$' in shift mode](#a4)  

**The function of the shift mode is to convert an input json into an expected json, only changing the data structure and not operating the data**
#### <a name="a1"></a>Simple format conversion
input :
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
 expected ：
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
 spec：
 ```json
[
  {
    "operation": "shift",
    "spec": {
      "order": {
        "orderItem": {
          "id": "orderForm.orderDetails.id", // Copy the value with id 3 to the path of "orderForm.orderDetails.id"
          "num": "orderForm.orderDetails.num" // Copy the value with num of 5 to "orderForm.orderDetails.num"
        }
      }
    }
  }
]
```
#### <a name="a2"></a>Simple use of '&' and '*' in shift mode
'*'The usage of '*' is similar to that in regular expressions, referring to fuzzy matching. Let's illustrate with specific examples below.   
input :
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
expected :
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
spec:   
```json
[
  {
    "operation": "shift",
    "spec": {
      "rating": {
        "*": { //Here '*' matches 'primary' and 'quality' in 'input'
          "value": "SecondaryRatings.data_&1.val" // &1 matches 'primary' or 'quality'
        }
      }
    }
  }
]
```
Here we will explain the usage of '&', such as the expression above, &1 means the key of the upper level of "value", the key of the upper level of "value"  
It is '\*', and because "\*" matches primary and quality, so &1 gets (primary or quality), and similarly &2 gets the key "rating"   

Let's use more specific examples to give you a better understanding of the usage of "&"  
The following will explain how to use the input value to be assigned to two keys  
input :
```json
{
  "rating_primary_value": 3
}
```  
expected:
```json
{
  "key_primary" : 3,
  "key_value" : 3
}
```
shift ,Here are two ways to show you  
```json
//way 1： 
[
  {
    "operation": "shift",
    "spec": {
    //The meaning of the array here is to copy the value of rating_primary_value to the key of the array element
      "rating_primary_value": ["key_primary", "key_value"] 
    }
  }
]

//way 2：
[
  {
    "operation": "shift",
    "spec": { 
    // The first "*" matches "primary", the second "*" matches "value"  
    //&(0,1) refers to the value matched by the first "*" sign, &(0,2) refers to the value matched by the second asterisk
      "rating_*_*": ["key_&(0,1)", "key_&(0,2)"]
    }
  }
]

//In the above example, the effect of &0 and &(0,0) is equivalent to matching "rating_primary_value", and &(0,1) refers to the value matched by a * in "rating_*_*"" primary", and so on 
// &1 and &(1,0) match "root", which will be explained later in our source code

```
#### <a name="a3"></a>Array transformation and use of '#' in shift mode  
The role of '#' is usually used to convert arrays. Let's explain with specific examples.
input :  
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
			"*": { // '*' matches the subscript of the orderItem array
				"orderItemId": "o_item.[#2].o_item_id", // #2 represents the second key from orderItemId up, which is 'orderItem', which represents the orderItem entered by the o_item array benchmark
				"orderItemNo": "o_item.[#2].o_item_no",
				"goods": {
					"*": {
						"goodsId": "o_item.[#4].o_goods.[#2].g_id", // Here it is similar to [#4]  is 'orderItem', [#2] is 'goods'
						"goodsNum": "o_item.[#4].o_goods.[#2].g_num"
					}
				}
			}
		}
	}
}]
```   
output：  
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
If the input json is an array, how to convert it, please see the following example  
input : 
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
expected：  
```json
[ {
  "orderId" : 1,
  "orderNo" : "2022xxxxxx01"
}, {
  "orderId" : 2,
  "orderNo" : "2022xxxxxx02"
} ]

```   
spec ：  
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
In fact, in addition to using '#' for array conversion, you can also use "&" to achieve, such as the above conversion, you can also use the following expression   
spec ：  
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
The shift mode also supports taking out the element with the specified subscript  
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
Get the element with index 0 spec：  
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
output：  
```json
{
  "order" : {
    "orderItemId" : 1,
    "orderItemNo" : "2022xxxxxx01"
  }
}
```

The difference between '&' converting an array and '#' is the value in [], '&' is 1 less than '#'  
[&] corresponds to the subscript, such as the above * matches the subscript 0 or 1, and [&1] only corresponds to the corresponding subscript 0 or 1  
[#] It corresponds to the key of the upper layer. As above, [#2] corresponds to the key 'root'. Some friends will ask where this 'root' comes from. There is no input in it. Don't worry about the follow-up. We will explain in detail in the source code   

**The above will be the use of '#' in LHS, let's take a look at the usage of '#' in RHS, '#' can assign a specified string to the output key in RHS**

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
output：  
```json
{
  "value" : "666",
  "rating" : "555",
  "primary" : "1234"
}
```   
The more commonly used conversion based on the above usage is the conversion of enumeration values  
Suppose we have an example like this, output a sex field, 1 for male, 2 for female, we need to convert this field into a SexEnum enumeration class  

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
input :  
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
        "1": { //If sex =1 , turn it into a male enumeration value
          "#男": "sex.desc",
          "#man": "sex.code"
        },
        "2": { //If sex =2 , turn it into a female enumeration value
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

#### <a name="a4"></a>Use of '$' in shift mode
The function of '$' is to use the key in the input as a value and map it to the json key of the output, see the following example  
input :  
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
        "*": { //"*" matches quality
          "$": "SecondaryRatings.Id" //"$" means to assign the key matched by "*" as a value to SecondaryRatings.Id
        }
      }
    }
  }
]

```   
output：  
```json
{
  "Rating" : 3,
  "SecondaryRatings" : {
    "Id" : "quality"
  }
}
```


