# 不同模式结合使用的相关案例讲解
jolt的表达式是一个列表,所以我们在使用的时候可以结合多种模式一起使用  

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
           // simple match.  Put the value '4' in the output under the "Rating" field
           "value": "Rating",
           "max": "RatingRange"
         },
         // match any children of "rating"
         // Shiftr has a precendence order when matching, so the "*" will match "last".
         // In this case anything that isn't "primary".
         "*": {
           // &1 means, go up one level and grab that value and substitute it in
           //  in this example &1 = "quality"
           "max":   "SecondaryRatings.&1.Range",
           "value": "SecondaryRatings.&1.Value",
           //
           // We want "quality" to be a value field in the output under
           //  "SecondaryRatings.quality.Id", but "quality" is an input key not an input value.
           // The "$" operator means use the input key, instead of the input value as ouput
           "$": "SecondaryRatings.&1.Id"
         }
       }
     }
   },
   {
     "operation": "default",
     "spec": {
       "Range": 5,
       "SecondaryRatings": {
         "*": {
           // Defaut all "SecondaryRatings" to have a Range of 5
           "Range": 5
         }
       }
     }
   }
 ]

 ```  
 expected 输出：
   ```json
{
  "Rating" : 3,
  "SecondaryRatings" : {
    "quality" : {
      "Id" : "quality",
      "Value" : 3,
      "Range" : 5
    }
  },
  "Range" : 5
}
  ```

