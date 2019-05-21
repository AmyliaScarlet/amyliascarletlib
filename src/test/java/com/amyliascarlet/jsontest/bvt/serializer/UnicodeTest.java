package com.amyliascarlet.jsontest.bvt.serializer;

import java.util.Collections;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;

public class UnicodeTest extends TestCase {
    public void test_unicode() throws Exception {
        String text = JSON.toJSONString(Collections.singletonMap("v", "\u0018"));
        System.out.println(text);
    }
}
