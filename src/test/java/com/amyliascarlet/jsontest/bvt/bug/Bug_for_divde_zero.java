package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;


public class Bug_for_divde_zero extends TestCase {
    public void test_divideZero() throws Exception {
        Double d = 1.0D / 0.0D;
        String text = JSON.toJSONString(d);
        System.out.println(text);
    }
}
