package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;


public class Bug_for_set extends TestCase {
    public void test_set() throws Exception {
        JSON.parseArray("Set[]");
    }
    
    public void test_treeset() throws Exception {
        JSON.parseArray("TreeSet[]");
    }
}
