package com.amyliascarlet.jsontest.bvt.serializer.filters;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class ClassLevelFeatureConfigTest_private extends TestCase {
    public void test_0() throws Exception {
        SerializeConfig config = new SerializeConfig();
        
        Model model = new Model();
        model.id = 1001;
        
        Assert.assertEquals("{\"id\":1001}", JSON.toJSONString(model, config));
        
        config.config(Model.class, SerializerFeature.BeanToArray, true);
        Assert.assertEquals("[1001]", JSON.toJSONString(model, config));
    }
    
    private static class Model {
        public int id;
    }
}
