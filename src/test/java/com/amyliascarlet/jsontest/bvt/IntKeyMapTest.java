package com.amyliascarlet.jsontest.bvt;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class IntKeyMapTest extends TestCase {

    public void test_0() throws Exception {
        JSON.parse("{1:\"AA\",2:{}}");
    }
}
