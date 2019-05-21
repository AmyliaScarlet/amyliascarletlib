package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

import java.util.Properties;

public class DenyTest9 extends TestCase {

    public void test_autoTypeDeny() throws Exception {
        ParserConfig config = new ParserConfig();

        assertFalse(config.isAutoTypeSupport());
        config.setAutoTypeSupport(true);
        assertTrue(config.isAutoTypeSupport());

        Properties properties = new Properties();
        properties.put(ParserConfig.AUTOTYPE_SUPPORT_PROPERTY, "false");
        properties.put(ParserConfig.AUTOTYPE_ACCEPT, "com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest9");
        // -ea -Dfastjson.parser.autoTypeAccept=com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest9
        config.configFromPropety(properties);

        assertFalse(config.isAutoTypeSupport());


        Object obj = JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest9$EasyThreadModel\"}", Object.class, config);
        assertEquals(Model.class, obj.getClass());
    }
    
    public static class Model {

    }

}
