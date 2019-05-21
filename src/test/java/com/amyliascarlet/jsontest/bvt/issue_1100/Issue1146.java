package com.amyliascarlet.jsontest.bvt.issue_1100;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import junit.framework.TestCase;

/**
 * Created by wenshao on 14/04/2017.
 */
public class Issue1146 extends TestCase {
    public void test_for_issue() throws Exception {
        String json = JSON.toJSONString(new Test());
        assertEquals("{\"zzz\":true}", json);
    }

    @JSONType(ignores = {"xxx", "yyy"})
    public static class Test {

        public boolean isXxx() {
            return true;
        }
        public boolean getYyy() {
            return true;
        }
        public boolean getZzz() {
            return true;
        }
    }
}
