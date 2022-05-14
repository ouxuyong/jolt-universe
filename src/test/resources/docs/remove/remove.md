# remove相关案例讲解  
remove 的作用是将json中不需要的key进行删除
#### 简单的remove例子

input 输入:
```json
{
  "rating": {
    "primary": {
      "value": 3,
      "id": 23
    },
    "quality": {
      "value": 3,
      "id": 24
    }
  }
}
   
 ```
  spec ：
```
[
  {
    "operation": "remove",
    "spec": {
      "rating": {
        "primary": "", //删除 rating.primary
        "quality": {
          "id": "" //删除 rating.quality.id
        }
      }
    }
  }
]
 ```  
 
 expected 输出：
   ```json
{
  "rating" : {
    "quality" : {
      "value" : 3
    }
  }
}
  ```
