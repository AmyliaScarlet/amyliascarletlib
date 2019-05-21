package com.amyliascarlet.jsontest.bvt.parser.autoType;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

public class AutoTypeTest6 extends TestCase {
    public void test_0() throws Exception {
        JSON.parseObject("{\"@type\":\"com.amyliascarlet.json.util.AntiCollisionHashMap\"}");
    }
}
