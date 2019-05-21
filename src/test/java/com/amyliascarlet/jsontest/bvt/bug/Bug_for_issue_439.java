package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;

public class Bug_for_issue_439 extends TestCase {
    public void test_for_issue() throws Exception {
       JSON.parseObject("{/*aa*/}");
    }
    
}
