package com.amyliascarlet.jsontest.bvt.awt;

import java.awt.Color;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AwtCodec;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;


public class ColorTest2 extends TestCase {
    public void test_color() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Color.class).getClass());
        
        Color color = Color.RED;
        String text = JSON.toJSONString(color, SerializerFeature.WriteClassName);
        System.out.println(text);
        
        Color color2 = (Color) JSON.parse(text);
        
        Assert.assertEquals(color, color2);
    }
}
