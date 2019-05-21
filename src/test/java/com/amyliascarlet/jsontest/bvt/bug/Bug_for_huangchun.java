package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;


public class Bug_for_huangchun extends TestCase {
    public void test_serialize_url() throws Exception {
        JSONObject json = new JSONObject();
        json.put("info", "<a href=\"http://www.baidu.com\"> 问题链接 </a> ");
        String text = JSON.toJSONString(json);
        System.out.println(text);
    }
}
