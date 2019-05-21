package com.amyliascarlet.jsontest.bvt.issue_1700;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

public class Issue1785 extends TestCase {
    public void test_for_issue() throws Exception {
        JSON.parseObject("\"2006-8-9\"", java.sql.Timestamp.class);
    }
}
