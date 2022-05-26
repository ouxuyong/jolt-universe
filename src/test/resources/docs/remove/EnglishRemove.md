# remove related case explanation  
The role of remove is to delete keys that are not needed in json  
#### Simple remove example

input :
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
```json
[
  {
    "operation": "remove",
    "spec": {
      "rating": {
        "primary": "", //remove rating.primary
        "quality": {
          "id": "" //remove rating.quality.id
        }
      }
    }
  }
]
 ```  
 
 expected ：
   ```json
{
  "rating" : {
    "quality" : {
      "value" : 3
    }
  }
}
  ```
