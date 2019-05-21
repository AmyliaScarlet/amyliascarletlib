package com.amyliascarlet.jsontest.bvt.issue_1700;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;

import java.util.Date;

public class Issue1727 extends TestCase {
    public void test_for_issue() throws Exception {
        String jsonString = "{\"gmtCreate\":\"20180131214157805-0800\"}";
        JSONObject.parseObject(jsonString, Model.class); //正常解析
        JSONObject.toJavaObject(JSON.parseObject(jsonString), Model.class);
    }

    public static class Model {
        @JSONField(format="yyyyMMddHHmmssSSSZ")
        public Date gmtCreate;
    }
}
