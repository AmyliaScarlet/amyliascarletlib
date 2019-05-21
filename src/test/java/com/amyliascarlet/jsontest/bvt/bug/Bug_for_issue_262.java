package com.amyliascarlet.jsontest.bvt.bug;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONPath;

import junit.framework.TestCase;

public class Bug_for_issue_262 extends TestCase {

    public void test_for_issue() throws Exception {
       String json = "{\"$\":\"zhugw\"}";
       Assert.assertEquals("zhugw", JSONPath.read(json, "/\\$"));
    }

   
    public static class Model {
        public String name;
    }
}
