package com.amyliascarlet.jsontest.bvt.serializer.filters;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class ClassLevelFeatureConfigTest3 extends TestCase {
    public void test_0() throws Exception {
        SerializeConfig config = new SerializeConfig();
        
        config.config(Model.class, SerializerFeature.BeanToArray, false);
        
        Model model = new Model();
        model.id = 1001;
        
        Assert.assertEquals("{\"id\":1001}", JSON.toJSONString(model, config));
        
        config.config(Model.class, SerializerFeature.BeanToArray, true);
        Assert.assertEquals("[1001]", JSON.toJSONString(model, config));        
    }
    
    @JSONType(serialzeFeatures=SerializerFeature.BeanToArray)
    public static class Model {
        public int id;
    }
}
