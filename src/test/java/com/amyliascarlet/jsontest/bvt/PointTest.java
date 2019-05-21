package com.amyliascarlet.jsontest.bvt;

import java.awt.Point;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AwtCodec;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;

import junit.framework.TestCase;

public class PointTest extends TestCase {

    public void test_color() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Point.class).getClass());
        
        Point point = new Point(3, 4);
        String text = JSON.toJSONString(point);

        Point point2 = JSON.parseObject(text, Point.class);

        Assert.assertEquals(point, point2);
    }
    
    public void test_color_2() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        Assert.assertEquals(AwtCodec.class, serializer.getObjectWriter(Point.class).getClass());
        
        Point point = new Point(5, 6);
        String text = JSON.toJSONString(point);

        Point point2 = JSON.parseObject(text, Point.class);

        Assert.assertEquals(point, point2);
    }
}
