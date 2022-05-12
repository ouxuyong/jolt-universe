## 快速入门


## 1在maven中添加 jolt的依赖 

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

latest.jolt.version 目前最新的版本为0.1.6 具体的版本号可以查看这里 [jolt历史版本](https://github.com/bazaarvoice/jolt/releases).


###  以下是具体的demo JoltSample.java

演示demo  [地址](https://github.com/ouxuyong/jolt-universe/blob/master/src/test/java/com/example/demo/shift/ShiftTest.java).

``` java
package com.example.demo.shift;

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

        Object input = JsonUtils.classpathToObject("/json/sample/input.json");
        List spec = JsonUtils.classpathToList("/json/sample/spec.json");
        Chainr chainr = Chainr.fromSpec(spec);
        Object transform = chainr.transform(input);
        System.out.println(JsonUtils.toJsonString(transform));
    }
}
```

### /json/sample/input.json
数据json文件 [地址](https://github.com/ouxuyong/jolt-universe/blob/master/src/test/resources/json/sample/input.json).

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
表达式json文件 [地址](https://github.com/ouxuyong/jolt-universe/blob/master/src/test/resources/json/sample/spec.json).

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


### 输出结果:

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
