package com.amyliascarlet.jsontest.bvt.serializer;

import java.util.Locale;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class LocalTest extends TestCase {

    public void test_timezone() throws Exception {
        String text = JSON.toJSONString(Locale.CHINA);

        Assert.assertEquals(JSON.toJSONString(Locale.CHINA.toString()), text);
     
        Locale locale = JSON.parseObject(text, Locale.class);
        Assert.assertEquals(Locale.CHINA, locale);
    }
}
