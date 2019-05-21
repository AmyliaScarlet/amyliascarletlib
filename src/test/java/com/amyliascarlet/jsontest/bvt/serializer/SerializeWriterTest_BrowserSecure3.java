package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class SerializeWriterTest_BrowserSecure3 extends TestCase {

    public void test_0() throws Exception {
        String text = JSON.toJSONString("\n", SerializerFeature.BrowserSecure);
        Assert.assertEquals("\"\\n\"", text);
    }

}
