package com.amyliascarlet.jsontest.bvt.parser.deser;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class ParseNullTest extends TestCase {
    public void test_parse_null() throws Exception {
        JSON.parseObject("{\"value\":null}", Model.class);
    }
    
    public static class Model {
        public JSONObject value;
    }
}
