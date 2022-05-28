# modify相关案例讲解  
modify又分成如下模式：  
modify-overwrite-beta： 模式是对指定的key的数据进行操作，无法key是否存在或已存在值，始终会对其进行操作  
default modify-default-beta ：当键值对应的值是null时写入  
define modify-define-beta ：当键值不存在时写入  
1. [modify 模式包含如下函数](#a1)  
2. [modify-overwrite-beta相关案例讲解](#a2)  
- 2.1[字符串相关处理](#a2_1)  
- 2.2[数学运算](#a2_2)  
- 2.3[类型转换](#a2_3)  
- 2.4[数组的操作](#a2_4)  

## <a name="a1"></a> modify 模式包含如下函数：  
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
其对应函数的功能和java同名函数一样  
toLower ：将字符转成小写  
toUpper ： 将字符转成大写  
concat ：合并字符串  
下面就不一一说明了，下文会详细讲解各自的用法


## <a name="a2"></a>modify-overwrite-beta相关案例讲解  
#### <a name="a2_1"></a>字符串相关处理
input 输入:
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
          "value": "=toString", //将 value转成字符串
          "value1": "=toLower", //将value1的字符变成小写
          "value2": "=toUpper", //将value2的字符变成大写
          "value3": "=concat(a,b,c,d,e,c,g)", //将括号里的数值拼成字符串
          "value4": "=join('_',5,4,5,6,7,8,9,90,0)", // 以‘—’将后面的元素连接在一起
          "value5": "=split('_','order_item_info')", //以‘_’分割字符串
          "value6": "=substring('abcdefg',3,3)", //截取‘abcdefg’的子串
          "value7": "=trim", // 去除 ‘ yy ’ 前后空格
          "value8": "=leftPad('abc',5,c)", // 5 - 'abc'.length()等于2，所在在左边增加两个c
          "value9": "=rightPad('abc',5,d)" // 5 - 'abc'.length()等于2，所在在右边增加两个d
        },
        "quality": {
          "value1": "=min(1,3,4,6)", // 从 1,3,4,6中选最小值赋值给value1
          "value2": "=max(1,3,4,6)" // 从 1,3,4,6中选最大值赋值给value2
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
  #### <a name="a2_2"></a>数学运算  
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
spec ：
```json
[
  {
    "operation": "modify-overwrite-beta",
    "spec": {
      "rating": {
        "quality": {
          "value1": "=min(1,3,4,6)", // 从 1,3,4,6中选最小值赋值给value1
          "value2": "=max(1,3,4,6)", // 从 1,3,4,6中选最大值赋值给value2
          "value3": "=abs(-100)", //取一个数据的绝对值
          "value4": "=avg(1,2,3)", // 取 1,2,3 的平均值
          "value5": "=intSum(1,2,3)", // int求和
          "value6": "=doubleSum(1.0,2.0,3.0)", // double求和
          "value7": "=longSum(10000,20000,30000)", //long求和
          "value8": "=intSubtract(6,2)", //整数减法 6-2
          "value9": "=doubleSubtract(6.0,2.2)", //浮点数减法6.0 - 2.2
          "value10": "=divide(10,2)", //除法 10/2
          "value11": "=divideAndRound(2,30,7)" //除法 30/7四舍五入，第一个2参数指的是保留几位小数
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
  #### <a name="a2_3"></a>类型转换  
 input 输入:
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
          "value1": "=toInteger", // 转换成int类型
          "value2": "=toDouble", // 转换成Double类型
          "value3": "=toLong", //转换成long类型
          "value4": "=toBoolean", //转换成Boolean类型
          "value5": "=toString", // 转换成String类型
          "value6": "=size", // 求字符串长度
          "value7": "=size(1,2,3,4,5,6,7,8)" //求数组元素个数
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
  
 #### <a name="a2_4"></a>数组的操作  
 
   input 输入:
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
          "value1": "=squashNulls", // 去除空值
          "value2": "=recursivelySquashNulls", // 递归去除空值
          "value3": "=squashDuplicates", //去除重复值
          "value4": "=firstElement", //取数组第一个值
          "value5": "=lastElement", // 取数组最后一个值
          "value6": "=elementAt(2,@(1,value0))", // 取value0数组下标为2的值
          "value7": "=toList(10)", //将元素转换数组
          "value8": "=sort(@(1,value0))" //将value0升序排序
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
