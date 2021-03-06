package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class Bug_for_jsonobj_null extends TestCase {

    public void test_parseObjectNull() throws Exception {
        JSON.parseObject("{\"data\":null}", VO.class);
    }

    public static class VO {

        private JSONObject data;

        public JSONObject getData() {
            return data;
        }

        public void setData(JSONObject data) {
            this.data = data;
        }

    }
}
