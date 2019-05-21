package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class Bug_for_zengjie extends TestCase {
    public void test_0 () throws Exception {
        JSON.parse("{123:'abc','value':{123:'abc'}}");
    }
}
