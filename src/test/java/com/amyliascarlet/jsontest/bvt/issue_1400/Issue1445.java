package com.amyliascarlet.jsontest.bvt.issue_1400;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

public class Issue1445 extends TestCase {
    public void test_for_issue() throws Exception {

        JSONObject obj = new JSONObject();
        obj.put("data", new JSONObject());
        obj.getJSONObject("data").put("data", new JSONObject());
        obj.getJSONObject("data").getJSONObject("data").put("map", new JSONObject());
        obj.getJSONObject("data").getJSONObject("data").getJSONObject("map").put("21160001", "abc");

        String json = JSON.toJSONString(obj);
        assertEquals("abc", JSONPath.read(json,"data.data.map.21160001"));
    }
}
