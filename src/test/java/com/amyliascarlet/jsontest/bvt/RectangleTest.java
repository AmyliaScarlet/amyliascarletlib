package com.amyliascarlet.jsontest.bvt;

import java.awt.Rectangle;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AwtCodec;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class RectangleTest extends TestCase {

    public void test_color() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Rectangle.class).getClass());
        
        Rectangle v = new Rectangle(3, 4, 100, 200);
        String text = JSON.toJSONString(v, SerializerFeature.WriteClassName);
        
        System.out.println(text);

        Rectangle v2 = (Rectangle) JSON.parse(text);

        Assert.assertEquals(v, v2);
    }
}
