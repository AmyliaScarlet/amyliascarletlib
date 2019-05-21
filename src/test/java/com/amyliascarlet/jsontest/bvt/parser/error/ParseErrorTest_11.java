package com.amyliascarlet.jsontest.bvt.parser.error;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;

import junit.framework.TestCase;

public class ParseErrorTest_11 extends TestCase {

    public void test_for_error() throws Exception {
        Exception error = null;
        try {
            JSON.parse("[123,");   
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
}
