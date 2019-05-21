package com.amyliascarlet.jsontest.bvt.serializer;

import java.awt.Color;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AwtCodec;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class ColorSerializerTest extends TestCase {

    public void test_null() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Color.class).getClass());

        VO vo = new VO();

        Assert.assertEquals("{\"value\":null}", JSON.toJSONString(vo, SerializerFeature.WriteMapNullValue));
    }

    public void test_rgb() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Color.class).getClass());

        VO vo = new VO();
        vo.setValue(new Color(1,1,1,0));

        Assert.assertEquals("{\"value\":{\"r\":1,\"g\":1,\"b\":1}}", JSON.toJSONString(vo, SerializerFeature.WriteMapNullValue));
    }
    
    public void test_rgb_getAutowiredFor() throws Exception {
        
    }

    private static class VO {

        private Color value;

        public Color getValue() {
            return value;
        }

        public void setValue(Color value) {
            this.value = value;
        }

    }
}
