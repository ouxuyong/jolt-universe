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
