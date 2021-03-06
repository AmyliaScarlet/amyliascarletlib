package com.amyliascarlet.jsontest.bvt.issue_1000;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by wenshao on 22/03/2017.
 */
public class Issue1095 extends TestCase {
    public void test_for_issue() throws Exception {
        String text = "{\"Grade\": 1, \"UpdateTime\": \"2017-03-22T11:41:17\"}";
        JSONObject jsonObject = JSON.parseObject(text, Feature.AllowISO8601DateFormat);
        assertEquals(Date.class, jsonObject.get("UpdateTime").getClass());
    }
}
