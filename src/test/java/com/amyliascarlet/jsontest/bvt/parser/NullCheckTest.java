package com.amyliascarlet.jsontest.bvt.parser;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class NullCheckTest extends TestCase {

    public void test_0() throws Exception {
        Assert.assertEquals(null, JSON.parse(null));
        Assert.assertEquals(null, JSON.parse(""));
        Assert.assertEquals(null, JSON.parse(" "));
    }
}
