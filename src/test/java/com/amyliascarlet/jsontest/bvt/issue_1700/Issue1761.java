package com.amyliascarlet.jsontest.bvt.issue_1700;

import com.amyliascarlet.lib.json.JSONObject;
import junit.framework.TestCase;

public class Issue1761 extends TestCase {
    public void test_for_issue() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("null","");
        double d = jsonObject.getDoubleValue("null");
        assertEquals(d, 0.0D);
    }
}
