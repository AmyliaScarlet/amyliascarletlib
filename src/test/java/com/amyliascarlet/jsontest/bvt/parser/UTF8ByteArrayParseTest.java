package com.amyliascarlet.jsontest.bvt.parser;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

public class UTF8ByteArrayParseTest extends TestCase {

    public void test_utf8() throws Exception {
        byte[] bytes = "{'name':'xxx', age:3, birthday:\"2009-09-05\"}".getBytes("UTF-8");

        JSON.parseObject(bytes, JSONObject.class);
    }
}
