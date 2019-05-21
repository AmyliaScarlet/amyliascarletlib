package com.amyliascarlet.jsontest.bvt.issue_1100;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import com.amyliascarlet.lib.json.TypeReference;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created by wenshao on 05/05/2017.
 */
public class Issue1177_2 extends TestCase {
    public void test_for_issue() throws Exception {
        String text = "{\"a\":{\"x\":\"y\"},\"b\":{\"x\":\"y\"}}";
        Map<String, Model> jsonObject = JSONObject.parseObject(text, new TypeReference<Map<String, Model>>(){});
        System.out.println(JSON.toJSONString(jsonObject));
        String jsonpath = "$..x";
        String value="y2";
        JSONPath.set(jsonObject, jsonpath, value);
        assertEquals("{\"a\":{\"x\":\"y2\"},\"b\":{\"x\":\"y2\"}}", JSON.toJSONString(jsonObject));

    }

    public static class Model {
        public String x;
    }
}
