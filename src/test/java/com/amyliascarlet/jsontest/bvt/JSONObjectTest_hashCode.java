package com.amyliascarlet.jsontest.bvt;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

public class JSONObjectTest_hashCode extends TestCase {

    public void test_hashCode() throws Exception {
        Assert.assertEquals(new JSONObject().hashCode(), new JSONObject().hashCode());
    }

    public void test_hashCode_1() throws Exception {
        Assert.assertEquals(JSON.parseObject("{a:1}"), JSON.parseObject("{'a':1}"));
    }
}
