package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class Bug_for_issue_676 extends TestCase {
    public void test_for_issue() throws Exception {
        JSON.parseObject("{\"modelType\":\"\"}", MenuExpend.class);
    }
    
    public static class MenuExpend {
        public ModelType modelType;
    }
    
    public static enum ModelType {
        A, B, C
    }
}
