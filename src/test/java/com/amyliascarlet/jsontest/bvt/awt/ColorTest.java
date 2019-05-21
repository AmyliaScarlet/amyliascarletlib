package com.amyliascarlet.jsontest.bvt.awt;

import java.awt.Color;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AwtCodec;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;

import junit.framework.TestCase;


public class ColorTest extends TestCase {
    public void test_color() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Color.class).getClass());
        
        Color color = Color.RED;
        String text = JSON.toJSONString(color);
        System.out.println(text);
        
        Color color2 = JSON.parseObject(text, Color.class);
        
        Assert.assertEquals(color, color2);
    }
}
