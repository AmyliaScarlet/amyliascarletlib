package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

public class JSONPath_set_test6 extends TestCase {
    public void test_jsonpath_1() throws Exception {
        JSONObject aa= new JSONObject();
        aa.put("app-a", "haj ");
        JSONPath.set(aa, "$.app\\-a\\.x", "123");
        assertEquals("haj ", aa.getString("app-a"));
        assertEquals("123", aa.getString("app-a.x"));
    }
}
