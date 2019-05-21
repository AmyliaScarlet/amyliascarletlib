package com.amyliascarlet.jsontest.bvt.serializer.features;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;
import org.junit.Assert;

public class JSONDirectTest_number extends TestCase {
    public void test_feature() throws Exception {
        Model model = new Model();
        model.id = 1001;
        model.value = "12.34";
        
        String json = JSON.toJSONString(model);
//        System.out.println(jsontest);
        Assert.assertEquals("{\"id\":1001,\"value\":12.34}", json);
    }

    public static class Model {
        public int id;
        @JSONField(jsonDirect=true)
        public String value;
    }
}
