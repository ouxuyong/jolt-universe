package com.example.oxy.customized;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomizedTest {
    @Test
    public void recursiveReplacement(){
        Object input = JsonUtils.classpathToObject("/json/customized/recursiveReplacementInput.json");
        List spec = JsonUtils.classpathToList("/json/customized/recursiveReplacementSpec.json");
        Chainr chainr = Chainr.fromSpec(spec);
        Object transform = chainr.transform(input);
        System.out.println(JsonUtils.toJsonString(transform));
    }

    /**
     * Support for recursive parent-child trees #1172
     */
    @Test
    public void recursiveReplacement_2(){
        Object input = JsonUtils.classpathToObject("/json/customized/recursiveReplacementInput_2.json");
        List spec = JsonUtils.classpathToList("/json/customized/recursiveReplacementSpec_2.json");
        Chainr chainr = Chainr.fromSpec(spec);
        Object transform = chainr.transform(input);
        System.out.println(JsonUtils.toJsonString(transform));


    }
}
