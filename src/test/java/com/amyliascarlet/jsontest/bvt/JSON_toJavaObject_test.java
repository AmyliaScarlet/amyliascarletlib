package com.amyliascarlet.jsontest.bvt;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.util.TypeUtils;

public class JSON_toJavaObject_test extends TestCase {

    public void test_0() throws Exception {
        A a = (A) JSON.toJavaObject(new JSONObject(), A.class);
        Assert.assertNotNull(a);
    }

    public void test_1() throws Exception {
        A a = (A) TypeUtils.cast(new B(), A.class, ParserConfig.getGlobalInstance());
        Assert.assertNotNull(a);
    }

    public static class A {

    }

    public static interface IB {

    }

    public static class B extends A implements IB {

    }
}
