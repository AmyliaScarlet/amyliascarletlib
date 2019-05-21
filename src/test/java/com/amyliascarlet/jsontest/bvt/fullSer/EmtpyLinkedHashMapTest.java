package com.amyliascarlet.jsontest.bvt.fullSer;

import java.util.Map;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;

public class EmtpyLinkedHashMapTest extends TestCase {
    public void test_0() throws Exception {
        Map map = (Map) JSON.parseObject("{\"@type\":\"java.util.LinkedHashMap\"}", Object.class);
    }
}
