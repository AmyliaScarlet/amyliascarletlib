package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

import java.util.Properties;

public class DenyTest7 extends TestCase {

    public void test_autoTypeDeny() throws Exception {
        ParserConfig config = new ParserConfig();

        assertFalse(config.isAutoTypeSupport());
        config.setAutoTypeSupport(true);
        assertTrue(config.isAutoTypeSupport());

        Properties properties = new Properties();
        properties.put(ParserConfig.AUTOTYPE_SUPPORT_PROPERTY, "false");

        config.configFromPropety(properties);

        assertFalse(config.isAutoTypeSupport());

        Exception error = null;
        try {
            Object obj = JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest7$EasyThreadModel\"}", Object.class, config);
            System.out.println(obj.getClass());
        } catch (JSONException ex) {
            error = ex;
        }
        assertNotNull(error);
    }
    
    public static class Model {

    }

}
