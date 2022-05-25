## Quick start


## 1 Add jolt dependency in maven 

Maven Dependency to Add to your pom file
``` xml
<dependency>
    <groupId>com.bazaarvoice.jolt</groupId>
    <artifactId>jolt-core</artifactId>
    <version>${latest.jolt.version}</version>
</dependency>
<dependency>
    <groupId>com.bazaarvoice.jolt</groupId>
    <artifactId>json-utils</artifactId>
    <version>${latest.jolt.version}</version>
</dependency>
```

latest.jolt.version 
The latest version is 0.1.6. The specific version number can be found here [jolt version](https://github.com/bazaarvoice/jolt/releases).


###  The following is the specific demo ShiftTest.java

demo  [demo location](src/test/java/com/example/oxy/shift/ShiftTest.java).

``` java
package com.example.oxy.shift;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShiftTest {

    /**
     * 测试demo
     */
    @Test
    public void testDemo() {
       //Convert json string to object type object
        Object input = JsonUtils.classpathToObject("/json/sample/input.json");
        //Convert json string to List type object
        List spec = JsonUtils.classpathToList("/json/sample/spec.json");
        Chainr chainr = Chainr.fromSpec(spec);
        Object transform = chainr.transform(input);
        System.out.println(JsonUtils.toJsonString(transform));
    }
}
```

### /json/sample/input.json
Data JSON file [location](src/test/resources/json/sample/input.json).

``` json
{
    "orderId": 1212,
    "orderNo":"202223434343",
    "goods": {
        "goodsId": 123,
        "goodsName": "test_goods"
    },
    "orderItem": [{
        "orderItemId": 1324,
        "orderItemNo": "34535345"
    }]
}
```

### /json/sample/spec.json
expression json file [location](src/test/resources/json/sample/spec.json).

``` json
[{
    "operation": "shift",
    "spec": {
        "orderId": "data.order_id",
        "orderNo": "data.order_no",
        "orderItem": {
            "*": {
                "orderItemId": "data.order_item.[#2].order_item_id",
                "orderItemNo": "data.order_item.[#2].order_item_no"
            }
        }
    }
},
    {
        "operation": "default",
        "spec": {
            "Range": 5,
            "data": {
                "default": 12345
            }
        }
    }
]
```


### output result:

``` json
{
  "data" : {
    "order_id" : 1212,
    "order_no" : "202223434343",
    "order_item" : [ {
      "order_item_id" : 1324,
      "order_item_no" : "34535345"
    } ],
    "default" : 12345
  },
  "Range" : 5
}
```
