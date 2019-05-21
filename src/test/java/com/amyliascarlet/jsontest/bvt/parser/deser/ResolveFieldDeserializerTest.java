package com.amyliascarlet.jsontest.bvt.parser.deser;

import com.amyliascarlet.lib.json.parser.deserializer.ResolveFieldDeserializer;

import junit.framework.TestCase;


public class ResolveFieldDeserializerTest extends TestCase {
    public void test_0 () throws Exception {
        new ResolveFieldDeserializer(null, null).parseField(null, null, null, null);
        new ResolveFieldDeserializer(null, null, 0).parseField(null, null, null, null);
    }
}
