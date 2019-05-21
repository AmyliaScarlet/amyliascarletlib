package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSONObject;


public class Issue94 extends TestCase {
    public void test_for_issue() throws Exception {
        JSONObject o = new JSONObject();
        o.put("line", "{\"1\":\u0080}");
        o.toString();
    }
}
