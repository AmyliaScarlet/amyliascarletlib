package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.ParserConfig;

import junit.framework.TestCase;

public class ParserConfigTest extends TestCase {

    public void test_0() throws Exception {
        ParserConfig config = new ParserConfig();
        config.getDeserializers();
    }
    
    
    public void test_1() throws Exception {
        ParserConfig config = new ParserConfig(Thread.currentThread().getContextClassLoader());
        
        Model model = JSON.parseObject("{\"value\":123}", Model.class, config);
        Assert.assertEquals(123, model.value);
    }
    
    public static class Model {
        public int value;
    }
}
