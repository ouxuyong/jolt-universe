#default相关案例讲解
####简单的赋默认值
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
 expected 预期输出：
   ```json
{
  "rating" : {
    "primary" : {
      "value" : 3,
      "Range" : 5
    },
    "quality" : {
      "value" : 3,
      "Range" : 5
    }
  },
  "Range" : 5
}
  ```
 jolt简单的表达式如下：
 ```
[
  {
    "operation": "default",
    "spec": {
      "Range": 5,
      "rating": {
        "*": {//这是的星号匹配的是key "primary" 和 "quality"
          // 给rating.primary.Range、rating.quality.Range赋默认值5
          "Range": 5
        }
      }
    }
  }
]
```  
default 默认是只能给不存在的key或key 为null的字段 赋默认值，如果对应的key已存在具体值default的配置则不会起效果  
```text
例子：  
input 输入:  
{
   "default": null
 } 
jolt 表达式：
 [
   {
     "operation": "default",
     "spec": {
       "Range": 5,
       "default": 6
     }
   }
 ]    
 expected输出结果：
{
  "default" : 6,
  "Range" : 5
}

input  如果输入的结果是：
{
   "default": 3
 }
 expected输出结果：
 {
   "default" : 3,
   "Range" : 5
 }

```
