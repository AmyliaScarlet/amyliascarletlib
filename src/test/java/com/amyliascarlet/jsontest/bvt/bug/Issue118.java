package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class Issue118 extends TestCase {
    public void test_for_issue() throws Exception {
        String json = JSON.toJSONString("\0");
        assertEquals("\"\\u0000\"", json);
    }
}
