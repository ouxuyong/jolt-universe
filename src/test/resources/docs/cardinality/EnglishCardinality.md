# Cardinality related case explanation

#### Simple cardinality example  
The role of the cardinality mode is to wrap a single data into an array, or take out the first element in the array  
'ONE':If the input value is a list, get the first element in the list and set it as the element's data, other types are not supported  
'MANY':If the input is not a list, create a list and set the first element to the input value. If the input is "null", make it an empty list. Not supported if the input is a list.  


input :
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
        "primary": "ONE", //Get the first element in primary
        "quality": "MANY" //convert quality to array
      }
    }
    }
]
 ```  
 
 expected ：
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
