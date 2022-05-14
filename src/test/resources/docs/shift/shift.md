#shift相关案例讲解
####简单的格式转换
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
 ```
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
####shift模式中‘&’和‘*'的简单使用
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
```text
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