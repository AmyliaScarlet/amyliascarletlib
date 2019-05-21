package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.parser.DefaultExtJSONParser;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.JSONSerializerMap;

import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class DeprecatedClassTest extends TestCase {
    @SuppressWarnings("resource")
    public void test_0() throws Exception {
        new DefaultExtJSONParser("");
        new DefaultExtJSONParser("", ParserConfig.getGlobalInstance(), 1);
        new DefaultExtJSONParser("".toCharArray(), 0, ParserConfig.getGlobalInstance(), 1);
    }
    
    public void test_1() throws Exception {
        new JSONSerializerMap().put(Object.class, null);
    }
}
