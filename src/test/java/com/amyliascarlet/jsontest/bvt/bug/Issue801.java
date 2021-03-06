package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by wenshao on 16/9/2.
 */
public class Issue801 extends TestCase {
    public void test_for_issue() throws Exception {
        String json = "{\"date\":\"0001-01-01T00:00:00\"}";
        Model model = JSON.parseObject(json, Model.class);
    }

    public static class Model {
        @JSONField(format = "yyyy-MM-ddTHH:mm:ss.SSS")
        public Date date;
    }
}
