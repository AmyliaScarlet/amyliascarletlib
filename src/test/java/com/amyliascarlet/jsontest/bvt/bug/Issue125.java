package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

public class Issue125 extends TestCase {

    public void test_for_issue() throws Exception {
        String content = "{\"data\":\"sfasfasdfasdfas\\r" + String.valueOf((char) 160) + "\\rasdfasdfasd\"}";
        JSONObject jsonObject = JSON.parseObject(content);
        System.out.println(jsonObject);
    }
}
