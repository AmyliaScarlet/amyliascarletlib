package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class Bug_for_JeryZeng extends TestCase {
    public void test_0() throws Exception {
        System.out.println(JSON.parseObject("{123:123,124:true,\"value\":{123:\"abc\"}}"));
    }
}
