package com.amyliascarlet.jsontest.bvt.parser.deser.asm;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.jsontest.test.benchmark.encode.EishayEncode;

import data.media.MediaContent;

public class TestASMEishay extends TestCase {
    public void test_asm() throws Exception {
        String text = JSON.toJSONString(EishayEncode.mediaContent, SerializerFeature.WriteEnumUsingToString);
        System.out.println(text);
        System.out.println(text.getBytes().length);
        MediaContent object = JSON.parseObject(text, MediaContent.class);
        String text2 = JSON.toJSONString(object, SerializerFeature.WriteEnumUsingToString);
        System.out.println(text2);
    }
}
