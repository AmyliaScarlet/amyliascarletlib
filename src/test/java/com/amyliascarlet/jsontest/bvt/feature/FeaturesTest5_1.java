package com.amyliascarlet.jsontest.bvt.feature;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;
import org.junit.Assert;

public class FeaturesTest5_1 extends TestCase {

    public void test_0() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.setAsmEnable(false);
        
        String text = JSON.toJSONString(new Entity(), config);
        Assert.assertEquals("{\"value\":false}", text);
    }
    
    public void test_1() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.setAsmEnable(true);
        
        String text = JSON.toJSONString(new Entity(), config);
        Assert.assertEquals("{\"value\":false}", text);
    }

    public static class Entity {

        private Boolean value;

        @JSONField(serialzeFeatures = { SerializerFeature.WriteNullBooleanAsFalse })
        public Boolean getValue() {
            return value;
        }


    }
}
