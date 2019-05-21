package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class SerializeConfigTest2 extends TestCase {

    public void test_1() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.setTypeKey("%type");
        Assert.assertEquals("%type", config.getTypeKey());
        
        Model model = new Model();
        model.value = 1001;

        Assert.assertEquals("{\"%type\":\"com.amyliascarlet.jsontest.bvt.serializer.SerializeConfigTest2$EasyThreadModel\",\"value\":1001}",
                            JSON.toJSONString(model, config, SerializerFeature.WriteClassName));
    }
    
    public static class Model {
        public int value;
    }
}
