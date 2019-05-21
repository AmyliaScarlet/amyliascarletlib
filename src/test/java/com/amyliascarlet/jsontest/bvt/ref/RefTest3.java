package com.amyliascarlet.jsontest.bvt.ref;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class RefTest3 extends TestCase {
    
    public void test_ref() throws Exception {
        Object[] array = new Object[1];
        array[0] = array;
        Assert.assertEquals("[{\"$ref\":\"@\"}]", JSON.toJSONString(array));
    }
    
    public void test_parse() throws Exception {
        Object[] array2 = JSON.parseObject("[{\"$ref\":\"$\"}]", Object[].class);
        Assert.assertSame(array2, array2[0]);
    }
    
    public void test_parse_1() throws Exception {
        Object[] array2 = JSON.parseObject("[{\"$ref\":\"@\"}]", Object[].class);
        Assert.assertSame(array2, array2[0]);
    }
}
