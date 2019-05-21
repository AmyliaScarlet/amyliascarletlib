package com.amyliascarlet.jsontest.bvt.path;

import java.util.HashMap;
import java.util.Map;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class JSONPath_conatinas_null extends TestCase {
    public void test_null() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", null);
        map.put("b", "1");

        String x = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        System.out.println(x);

        JSONObject jsonObject = JSON.parseObject(x);
        System.out.println(JSONPath.contains(jsonObject, "$.a") + "\t" + jsonObject.containsKey("a"));
        System.out.println(JSONPath.contains(jsonObject, "$.b") + "\t" + jsonObject.containsKey("b"));
    }
}
