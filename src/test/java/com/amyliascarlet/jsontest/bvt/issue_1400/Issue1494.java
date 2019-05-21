package com.amyliascarlet.jsontest.bvt.issue_1400;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

public class Issue1494 extends TestCase {
    public void test_for_issue() throws Exception {
        String json = "{\"id\":1001,\"name\":\"wenshao\"}";
        B b = JSON.parseObject(json, B.class);
        assertEquals("{\"id\":1001,\"name\":\"wenshao\"}", JSON.toJSONString(b));
    }

    public static class A {
        private int id;

        public int getId() {
            return id;
        }
    }

    @JSONType(parseFeatures = Feature.SupportNonPublicField)
    public static class B extends A {
        private String name;

        public String getName() {
            return name;
        }
    }
}
