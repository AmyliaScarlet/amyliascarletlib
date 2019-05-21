package com.amyliascarlet.jsontest.bvt.parser.error;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;

import junit.framework.TestCase;

public class ParseErrorTest_9 extends TestCase {

    public void test_for_error() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":33\"}", Model.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_for_error_2() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":\"33\"", Model.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_for_error_3() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":\"33\",", Model.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_for_error_4() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":\"33\"},", Model.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public static class Model {
        public long value;
    }
    
}
