package com.amyliascarlet.jsontest.bvt.parser.deser;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class MapDeserializerTest extends TestCase {
    protected void setUp() throws Exception {
        com.amyliascarlet.lib.json.parser.ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.parser.deser.MapDeserializerTest.");
    }

    public void test_0() throws Exception {
        JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.deser.MapDeserializerTest$MyMap\"}", Map.class);
    }
    
    public static class MyMap extends HashMap {
        public MyMap () {
            
        }
    }
}
