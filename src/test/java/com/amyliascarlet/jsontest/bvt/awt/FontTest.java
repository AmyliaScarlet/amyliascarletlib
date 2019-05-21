package com.amyliascarlet.jsontest.bvt.awt;

import java.awt.Font;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class FontTest extends TestCase {

    public void test_color() throws Exception {
        Font[] fonts = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        for (Font font : fonts) {
            String text = JSON.toJSONString(font);

            Font font2 = JSON.parseObject(text, Font.class);

            Assert.assertEquals(font, font2);
        }
    }
}
