package com.amyliascarlet.jsontest.bvt.bug;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONArray;
import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class Bug_for_issue_434 extends TestCase {

    public void test_for_issue() throws Exception {
        String json = "{value:[\"null\"]}";
        JSONObject parse = JSONObject.parseObject(json);
        JSONArray jsonArray = parse.getJSONArray("value");
        Assert.assertEquals(1, jsonArray.size());
    }

}
