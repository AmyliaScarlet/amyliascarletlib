package com.amyliascarlet.jsontest.bvt.parser.deser;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.Feature;

import junit.framework.TestCase;

public class ConstructorErrorTest_initError_private extends TestCase {

    public void test_error() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{}", Model.class, Feature.InitStringFieldAsEmpty);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }

    private static class Model {
        
        public Model(){
            
        }
        
        public void setName(String name) {
            throw new IllegalStateException();
        }
    }
}
