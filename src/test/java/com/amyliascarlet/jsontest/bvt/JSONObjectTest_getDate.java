package com.amyliascarlet.jsontest.bvt;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class JSONObjectTest_getDate extends TestCase {

    public void test_get_empty() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("value", "");
        Assert.assertEquals("", obj.get("value"));
        Assert.assertNull(obj.getDate("value"));
    }
}
