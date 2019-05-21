package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

public class Issue177 extends TestCase {

    public void test_for_issue_177() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", new byte[20]);

        String jsonString = JSON.toJSONString(jsonObject);
        JSONObject parseObject = JSON.parseObject(jsonString);

        byte[] bytes = parseObject.getBytes("data");

        byte[] bs = parseObject.getObject("data", byte[].class);
    }
}
