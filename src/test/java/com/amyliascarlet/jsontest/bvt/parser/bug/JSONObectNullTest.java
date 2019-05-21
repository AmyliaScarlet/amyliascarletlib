package com.amyliascarlet.jsontest.bvt.parser.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import junit.framework.TestCase;

/**
 * Created by wenshao on 01/04/2017.
 */
public class JSONObectNullTest extends TestCase {

    public void test_for_null() throws Exception {
        Model model = JSON.parseObject("{\"value\":null}", Model.class);
    }

    public void test_for_null2() throws Exception {
        JSON.parseObject("null");
    }

    public static class Model {
        public JSONObject value;
    }
}
