package com.amyliascarlet.jsontest.bvt.util;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.util.AntiCollisionHashMap;
import junit.framework.TestCase;

public class AntiCollisionHashMapTest_writeClassName extends TestCase {
    public void test_for_bug() throws Exception {
        Model m = JSON.parseObject("{\"value\":{\"@type\":\"com.amyliascarlet.json.util.AntiCollisionHashMap\"}}", Model.class);
        assertTrue(m.value.getInnerMap() instanceof AntiCollisionHashMap);
    }

    public static class Model {
        public JSONObject value;
    }
}
