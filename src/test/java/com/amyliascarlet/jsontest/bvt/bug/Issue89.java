package com.amyliascarlet.jsontest.bvt.bug;

import org.junit.Assert;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class Issue89 extends TestCase {

    public void test_for_issue() throws Exception {
        Exception error = null;
        try {
            JSON.parse("{\"a\":з」∠)_,\"}");
        } catch (Exception ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
}
