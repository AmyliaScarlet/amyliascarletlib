package com.amyliascarlet.jsontest.bvt.bug;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class Issue171 extends TestCase {

    public void test_for_issue() throws Exception {
        Map m = new HashMap();
        m.put("a", "\u000B");
        String json = JSON.toJSONString(m);
        System.out.println(json);
        JSON.parse(json);
    }
}
