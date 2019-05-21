package com.amyliascarlet.jsontest.bvt.parser.deser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class NumberDeserializerTest2 extends TestCase {

    public void test_double2() throws Exception {
        Assert.assertTrue(123.0D == JSON.parseObject("123B", double.class));
        Assert.assertTrue(123.0D == JSON.parseObject("123B", Double.class).doubleValue());
    }
}
