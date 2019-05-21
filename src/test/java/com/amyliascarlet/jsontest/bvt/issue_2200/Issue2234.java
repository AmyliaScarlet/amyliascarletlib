package com.amyliascarlet.jsontest.bvt.issue_2200;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

import java.util.List;

public class Issue2234 extends TestCase {
    public void test_for_issue() throws Exception {
        String userStr = "{\"name\":\"asdfad\",\"ss\":\"\"}";
        User user = JSON.parseObject(userStr, User.class);
    }

    public static class User {
        public String name;
        public List ss;
    }
}
