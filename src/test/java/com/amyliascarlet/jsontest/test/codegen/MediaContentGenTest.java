package com.amyliascarlet.jsontest.test.codegen;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.codegen.DeserializerGen;

import data.media.MediaContent;

public class MediaContentGenTest extends TestCase {

    public void test_codegen() throws Exception {
        StringBuffer out = new StringBuffer();
        DeserializerGen generator = new DeserializerGen(MediaContent.class, out);

        generator.gen();

        System.out.println(out.toString());
    }
}
