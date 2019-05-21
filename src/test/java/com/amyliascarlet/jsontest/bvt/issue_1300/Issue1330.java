package com.amyliascarlet.jsontest.bvt.issue_1300;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import junit.framework.TestCase;

/**
 * Created by wenshao on 30/07/2017.
 */
public class Issue1330 extends TestCase {
    public void test_for_issue() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":\"ABC\"}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
        assertTrue(error.getMessage().indexOf("parseInt error, field : value") != -1);
    }

    public void test_for_issue_1() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":[]}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
        assertTrue(error.getMessage().indexOf("parseInt error, field : value") != -1);
    }

    public void test_for_issue_2() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":{}}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
        assertTrue(error.getMessage().indexOf("parseInt error, field : value") != -1);
    }

    public static class Model {
        public int value;
    }
}