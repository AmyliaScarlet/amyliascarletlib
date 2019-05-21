package com.amyliascarlet.jsontest.bvt.path;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONPath;

import junit.framework.TestCase;

public class JSONPointTest_1 extends TestCase {

    private Object json;

    protected void setUp() throws Exception {
        String text = "[{\"name\":\"ljw\",\"age\":123}]";
        json = JSON.parse(text);
    }

    
    public void test_key_1() throws Exception {
        Object val = JSONPath.eval(json, "/0/name");
        Assert.assertEquals("ljw", val);
    }
}
