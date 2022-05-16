# cardinality相关案例讲解

#### 简单的cardinality例子  
cardinality模式的作用是可以将单个数据包装成数组，或者取出数组中第一个元素  
'ONE':如果输入值是一个列表，则获取该列表中的第一个元素，并将其设置为该元素的数据,不支持其他类型  
'MANY':如果输入不是列表，则创建一个列表并将第一个元素设置为输入值。如果输入是"null"，使它成为一个空列表。如果输入是一个列表，不支持。


input 输入:
```json
{
    "rating": {
        "primary": [
            {
                "value": 3,
                "id": 23
            },
            {
                "value": 3,
                "id": 23
            }
        ],
        "quality": {
            "value": 5,
            "id": 25
        }
    }
}
   
 ```
spec ：
```json
[
  {
    "operation": "cardinality",
    "spec": {
      "rating": {
        "primary": "ONE", //取出 primary 中的一个元素
        "quality": "MANY" //将 quality 转换成数组
      }
    }
    }
]
 ```  
 
 expected 输出：
   ```json
{
    "rating": {
        "primary": {
            "value": 3,
            "id": 23
        },
        "quality": [
            {
                "value": 5,
                "id": 25
            }
        ]
    }
}
  ```
