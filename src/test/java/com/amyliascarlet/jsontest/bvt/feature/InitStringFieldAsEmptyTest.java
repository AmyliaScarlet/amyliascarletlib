package com.amyliascarlet.jsontest.bvt.feature;

import org.junit.Assert;

import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.Feature;

import junit.framework.TestCase;

public class InitStringFieldAsEmptyTest extends TestCase {
    public void test_0() throws Exception {
        DefaultJSONParser parser = new DefaultJSONParser("{}");
        parser.config(Feature.InitStringFieldAsEmpty, true);
        Model model = parser.parseObject(Model.class);
        Assert.assertEquals("", model.value);
        parser.close();
    }
    
    public void test_1() throws Exception {
        DefaultJSONParser parser = new DefaultJSONParser("{}");
        parser.config(Feature.InitStringFieldAsEmpty, false);
        Model model = parser.parseObject(Model.class);
        Assert.assertNull(null, model.value);
        parser.close();
    }
    
    public static class Model {
        public Model() {
            
        }
        public String value;
    }
}
