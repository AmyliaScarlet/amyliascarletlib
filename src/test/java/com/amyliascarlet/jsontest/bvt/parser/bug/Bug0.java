package com.amyliascarlet.jsontest.bvt.parser.bug;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONArray;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONObject;

public class Bug0 extends TestCase {

    public void test_0() throws Exception {
        String text = "{a:1,b:2}";
        JSONObject json = JSON.parseObject(text, JSONObject.class);
        Assert.assertEquals(1, json.getIntValue("a"));
        Assert.assertEquals(2, json.getIntValue("b"));
    }

    public void test_array_exception() throws Exception {
        String text = "[1, 2]}";
        Exception error = null;
        try {
            JSON.parseObject(text, JSONArray.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
}
