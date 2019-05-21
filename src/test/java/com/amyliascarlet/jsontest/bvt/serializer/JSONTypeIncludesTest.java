package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;

import junit.framework.TestCase;

public class JSONTypeIncludesTest extends TestCase {
    public void test_includes() throws Exception {
        Model model = new Model();
        model.id = 1001;
        model.name = "wenshao";
        
        String text = JSON.toJSONString(model);
        System.out.println(text);
    }
    
    @JSONType(includes="name")
    public static class Model {
        public int id;
        public String name;
    }
}
