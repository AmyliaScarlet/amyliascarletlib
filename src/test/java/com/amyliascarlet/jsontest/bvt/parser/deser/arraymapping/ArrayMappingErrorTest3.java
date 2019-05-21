package com.amyliascarlet.jsontest.bvt.parser.deser.arraymapping;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.Feature;

import junit.framework.TestCase;

public class ArrayMappingErrorTest3 extends TestCase {

    public void test_for_error() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("[1001,{}}", Model.class, Feature.SupportArrayToBean);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }

    public static class Model {

        public int    id;
        public JSONObject obj;
        public JSONObject obj2;

    }
}
