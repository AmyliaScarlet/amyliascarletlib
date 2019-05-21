package com.amyliascarlet.jsontest.bvt.ref;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class RefTest19 extends TestCase {
    public void test_array() throws Exception {
        String text = "{\"b\":{},\"a\":{\"$ref\":\"$.b\"}}";
        
        JSONObject obj = JSON.parseObject(text);
        JSONObject a = obj.getJSONObject("a");
        JSONObject b = obj.getJSONObject("b");
        Assert.assertSame(a, b);
    }
}
