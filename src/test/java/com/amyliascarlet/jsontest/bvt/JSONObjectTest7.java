package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import junit.framework.TestCase;

public class JSONObjectTest7 extends TestCase {

    public void test() throws Exception {
        JSONObject jsonObject = JSON.parseObject("{\"test\":null,\"a\":\"cc\"}");
        assertEquals(2, jsonObject.entrySet().size());
        assertTrue(jsonObject.containsKey("test"));
    }

}
