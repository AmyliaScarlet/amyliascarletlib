package com.amyliascarlet.jsontest.bvt.awt;

import java.awt.Font;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class FontTest2 extends TestCase {

    public void test_color() throws Exception {
        Font[] fonts = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for (Font font : fonts) {
            String text = JSON.toJSONString(font, SerializerFeature.WriteClassName);

            Font font2 = (Font) JSON.parse(text);

            Assert.assertEquals(font, font2);
        }
    }
}
