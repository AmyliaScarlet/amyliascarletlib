package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

public class Bug_for_liqing extends TestCase {
    public void test_for_issue() throws Exception {
        ParserConfig config = new ParserConfig();
        config.setAutoTypeSupport(true);
        String json = "{\"@type\":\"java.util.HashMap\",\"wcChangeAttr\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.bug.Bug_for_liqing.TpFeedBackDO\",\"attributes\":{\"@type\":\"java.util.concurrent.ConcurrentHashMap\"},\"wcStatus\":102B}}";
        JSON.parse(json, config);
    }

    public static class TpFeedBackDO {

    }
}
