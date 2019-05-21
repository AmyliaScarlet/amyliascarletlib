package com.amyliascarlet.jsontest.bvt.serializer;

import java.awt.Rectangle;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AwtCodec;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;


public class RectangleSerializerTest extends TestCase {
    
    public void test_null() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Rectangle.class).getClass());
        
        VO vo = new VO();
        
        Assert.assertEquals("{\"value\":null}", JSON.toJSONString(vo, SerializerFeature.WriteMapNullValue));
    }

    private static class VO {

        private Rectangle value;

        public Rectangle getValue() {
            return value;
        }

        public void setValue(Rectangle value) {
            this.value = value;
        }

    }
}
