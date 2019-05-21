package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.util.ASMUtils;


public class Issue109 extends TestCase {
    public void test_for_issue() throws Exception {
        Assert.assertFalse(ASMUtils.isAndroid(null));
    }
}
