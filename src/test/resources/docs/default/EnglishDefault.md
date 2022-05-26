# Default related case explanation
The role of default is to assign a default value to json. If the corresponding key does not exist or the value is null, assign a default value to it  
#### Simple assignment of default values
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
 expected ：
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
 jolt The simple expression is as follows：
 ```json
[
  {
    "operation": "default",
    "spec": {
      "Range": 5,
      "rating": {
        "*": {//This is where the asterisk matches the keys "primary" and "quality"
          // Default value 5 for 'rating.primary.Range', 'rating.quality.Range'
          "Range": 5
        }
      }
    }
  }
]
```  
The default default is to only assign a default value to a non-existing key or a field whose key is null. If the corresponding key already has a specific value default configuration, it will not work.  
```text
example：  
input :  
{
   "default": null
 } 
jolt ：
 [
   {
     "operation": "default",
     "spec": {
       "Range": 5,
       "default": 6
     }
   }
 ]    
 expected：
{
  "default" : 6,
  "Range" : 5
}

input  If the input result is：
{
   "default": 3
 }
 expected：
 {
   "default" : 3,
   "Range" : 5
 }

```
