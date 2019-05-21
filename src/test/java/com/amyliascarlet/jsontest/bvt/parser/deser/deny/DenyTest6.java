package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

public class DenyTest6 extends TestCase {

    public void test_autoTypeDeny() throws Exception {
        ParserConfig config = new ParserConfig();
        assertFalse(config.isAutoTypeSupport());
        config.setAutoTypeSupport(true);
        assertTrue(config.isAutoTypeSupport());
        config.addDeny("com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest6");
        config.setAutoTypeSupport(false);

        Exception error = null;
        try {
            Object obj = JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest6$EasyThreadModel\"}", Object.class, config);
            System.out.println(obj.getClass());
        } catch (JSONException ex) {
            error = ex;
        }
        assertNotNull(error);
    }
    
    public static class Model {

    }

}
