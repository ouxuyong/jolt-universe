# Modify related case explanation  
modify is divided into the following modes:   
modify-overwrite-beta： The mode is to operate on the data of the specified key, whether the key exists or has an existing value, it will always operate on it  
default modify-default-beta ：Write when the value corresponding to the key value is null   
define modify-define-beta ：Write when key value does not exist    

1. [The modify mode contains the following functions](#a1)  
2. [Modify-overwrite-beta related case explanation](#a2)  
- 2.1 [String related processing](#a2_1)  
- 2.2 [computation](#a2_2)  
- 2.3 [type conversion](#a2_3)  
- 2.4 [operations on arrays](#a2_4)  
## <a name="a1"></a>The modify mode contains the following functions:    
```text
    private static final Map<String, Function> STOCK_FUNCTIONS = new HashMap<>(  );

    static {
        STOCK_FUNCTIONS.put( "toLower", new Strings.toLowerCase() );
        STOCK_FUNCTIONS.put( "toUpper", new Strings.toUpperCase() );
        STOCK_FUNCTIONS.put( "concat", new Strings.concat() );
        STOCK_FUNCTIONS.put( "join", new Strings.join() );
        STOCK_FUNCTIONS.put( "split", new Strings.split() );
        STOCK_FUNCTIONS.put( "substring", new Strings.substring() );
        STOCK_FUNCTIONS.put( "trim", new Strings.trim() );
        STOCK_FUNCTIONS.put( "leftPad", new Strings.leftPad() );
        STOCK_FUNCTIONS.put( "rightPad", new Strings.rightPad() );

        STOCK_FUNCTIONS.put( "min", new Math.min() );
        STOCK_FUNCTIONS.put( "max", new Math.max() );
        STOCK_FUNCTIONS.put( "abs", new Math.abs() );
        STOCK_FUNCTIONS.put( "avg", new Math.avg() );
        STOCK_FUNCTIONS.put( "intSum", new Math.intSum() );
        STOCK_FUNCTIONS.put( "doubleSum", new Math.doubleSum() );
        STOCK_FUNCTIONS.put( "longSum", new Math.longSum() );
        STOCK_FUNCTIONS.put( "intSubtract", new Math.intSubtract() );
        STOCK_FUNCTIONS.put( "doubleSubtract", new Math.doubleSubtract() );
        STOCK_FUNCTIONS.put( "longSubtract", new Math.longSubtract() );
        STOCK_FUNCTIONS.put( "divide", new Math.divide() );
        STOCK_FUNCTIONS.put( "divideAndRound", new Math.divideAndRound() );


        STOCK_FUNCTIONS.put( "toInteger", new Objects.toInteger() );
        STOCK_FUNCTIONS.put( "toDouble", new Objects.toDouble() );
        STOCK_FUNCTIONS.put( "toLong", new Objects.toLong() );
        STOCK_FUNCTIONS.put( "toBoolean", new Objects.toBoolean() );
        STOCK_FUNCTIONS.put( "toString", new Objects.toString() );
        STOCK_FUNCTIONS.put( "size", new Objects.size() );
        STOCK_FUNCTIONS.put( "toJsonString", new Objects.toJsonString() );

        STOCK_FUNCTIONS.put( "squashNulls", new Objects.squashNulls() );
        STOCK_FUNCTIONS.put( "recursivelySquashNulls", new Objects.recursivelySquashNulls() );
        STOCK_FUNCTIONS.put( "squashDuplicates", new Objects.squashDuplicates() );

        STOCK_FUNCTIONS.put( "noop", Function.noop );
        STOCK_FUNCTIONS.put( "isPresent", Function.isPresent );
        STOCK_FUNCTIONS.put( "notNull", Function.notNull );
        STOCK_FUNCTIONS.put( "isNull", Function.isNull );

        STOCK_FUNCTIONS.put( "firstElement", new Lists.firstElement() );
        STOCK_FUNCTIONS.put( "lastElement", new Lists.lastElement() );
        STOCK_FUNCTIONS.put( "elementAt", new Lists.elementAt() );
        STOCK_FUNCTIONS.put( "toList", new Lists.toList() );
        STOCK_FUNCTIONS.put( "sort", new Lists.sort() );
    }
```  
The function of its corresponding function is the same as that of the java function of the same name  
toLower ：Convert characters to lowercase  
toUpper ： convert characters to uppercase  
concat ：Merge strings    
The following will not explain them one by one, the following will explain their usage in detail  


##<a name="a2"></a> Modify-overwrite-beta related case explanation  
#### <a name="a2_1"></a>String related processing
input :
```json
{
  "rating": {
    "primary": {
      "value": 3,
      "value1": "ABC",
      "value2": "dnf"
    },
    "quality": {
      "value": 3
    }
  }
}
```  
spec ：
```json
[
  {
    "operation": "modify-overwrite-beta",
    "spec": {
      "rating": {
        "primary": {
          "value": "=toString", //convert value to string
          "value1": "=toLower", //Convert the characters of value1 to lowercase
          "value2": "=toUpper", //Convert the characters of value2 to uppercase
          "value3": "=concat(a,b,c,d,e,c,g)", //Spell the numbers in parentheses into strings
          "value4": "=join('_',5,4,5,6,7,8,9,90,0)", // Use '-' to connect the following elements together
          "value5": "=split('_','order_item_info')", //split string with '_'
          "value6": "=substring('abcdefg',3,3)", //Truncate a substring of 'abcdefg'
          "value7": "=trim", // Remove spaces before and after ' yy '
          "value8": "=leftPad('abc',5,c)", // 5 - 'abc'.length()Equal to 2, where two c's are added to the left
          "value9": "=rightPad('abc',5,d)" // 5 - 'abc'.length()equal to 2, where two d's are added to the right
        },
        "quality": {
          "value1": "=min(1,3,4,6)", // Select the smallest value from 1,3,4,6 and assign it to value1
          "value2": "=max(1,3,4,6)" // Select the maximum value from 1,3,4,6 and assign it to value2
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
    "primary" : {
      "value" : "3",
      "value1" : "abc",
      "value2" : "DNF",
      "value7" : "yy",
      "value3" : "abcdecg",
      "value4" : "5_4_5_6_7_8_9_90_0",
      "value5" : [ "order", "item", "info" ],
      "value8" : "ccabc",
      "value9" : "abcdd"
    },
    "quality" : {
      "value" : 3,
      "value1" : 1,
      "value2" : 6
    }
  }
}
  ```  
  #### <a name="a2_2"></a>computation  
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
spec ：
```json
[
  {
    "operation": "modify-overwrite-beta",
    "spec": {
      "rating": {
        "quality": {
          "value1": "=min(1,3,4,6)", // Select the smallest value from 1,3,4,6 and assign it to value1
          "value2": "=max(1,3,4,6)", // Select the maximum value from 1,3,4,6 and assign it to value2
          "value3": "=abs(-100)", //Take the absolute value of a data
          "value4": "=avg(1,2,3)", // Take the average of 1,2,3
          "value5": "=intSum(1,2,3)", // int summation
          "value6": "=doubleSum(1.0,2.0,3.0)", // double summation
          "value7": "=longSum(10000,20000,30000)", //long summation
          "value8": "=intSubtract(6,2)", //Integer Subtraction 6-2
          "value9": "=doubleSubtract(6.0,2.2)", //double subtraction 6.0 - 2.2
          "value10": "=divide(10,2)", //divide 10/2
          "value11": "=divideAndRound(2,30,7)" //Division 30/7 rounds, the first parameter '2' refers to the number of decimal places
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
    "primary" : {
      "value" : 3
    },
    "quality" : {
      "value" : 3,
      "value1" : 1,
      "value2" : 6,
      "value3" : 100,
      "value4" : 2.0,
      "value5" : 6,
      "value6" : 6.0,
      "value7" : 60000,
      "value8" : 4,
      "value9" : 3.8,
      "value10" : 5.0,
      "value11" : 4.29
    }
  }
}

  ```  
  #### <a name="a2_3"></a>type conversion  
 input :
```json
{
  "rating": {
    "primary": {
      "value1": "3",
      "value2": 2,
      "value3": "33",
      "value4": "false",
      "value5": 1999,
      "value6": "123456789"
    }
  }
}
```  
spec ：
```json
[
  {
    "operation": "modify-overwrite-beta",
    "spec": {
      "rating": {
        "primary": {
          "value1": "=toInteger", // Convert to int type
          "value2": "=toDouble", // Convert to Double type
          "value3": "=toLong", //Convert to long type
          "value4": "=toBoolean", //Convert to Boolean type 
          "value5": "=toString", // Convert to String type
          "value6": "=size", // find the length of the string
          "value7": "=size(1,2,3,4,5,6,7,8)" //Find the number of elements in an array
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
    "primary" : {
      "value1" : 3,
      "value2" : 2.0,
      "value3" : 33,
      "value4" : false,
      "value5" : "1999",
      "value6" : 9,
      "value7" : 8
    }
  }
}

  ```    
  
 #### <a name="a2_4"></a>operations on arrays  
 
   input :
```json
{
  "rating": {
    "primary": {
      "value0":[6,5,4,3,2,1],
      "value1": [ "a", null, 1, null, "b" ],
      "value2": [ "a", null, { "x": "X", "y": null, "zList" : [ "z1", null, "z3" ] }, null, "b"  ],
      "value3": [ "abc", "abc", "xyz", "cde", "bcd" ],
      "value4": [ "abc", "abc", "xyz", "cde", "bcd" ],
      "value5": [ "abc", "abc", "xyz", "cde", "bcd" ],
      "value6": [ "abc", "abc", "xyz", "cde", "bcd" ]
      
    }
  }
}
```  
spec ：
```json
[
  {
    "operation": "modify-overwrite-beta",
    "spec": {
      "rating": {
        "primary": {
          "value1": "=squashNulls", // remove nulls
          "value2": "=recursivelySquashNulls", // Recursively remove nulls
          "value3": "=squashDuplicates", //remove duplicate values
          "value4": "=firstElement", //get the first value of the array
          "value5": "=lastElement", // get the last value of an array
          "value6": "=elementAt(2,@(1,value0))", // Take the value with the subscript 2 of the value0 array
          "value7": "=toList(10)", //convert element to array
          "value8": "=sort(@(1,value0))" //sort value0 in ascending order
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
    "primary" : {
      "value0" : [ 6, 5, 4, 3, 2, 1 ],
      "value1" : [ "a", 1, "b" ],
      "value2" : [ "a",  {"x" : "X","zList" : [ "z1", "z3" ] }, "b" ],
      "value3" : [  "abc", "xyz", "cde", "bcd" ],
      "value4" : "abc",
      "value5" : "bcd",
      "value6" : 4,
      "value7" : [ 10 ],
      "value8" : [ 1, 2, 3, 4, 5, 6 ]
    }
  }
}

  ```    
