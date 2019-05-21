package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

import java.util.Properties;

/**
 * Created by wenshao on 28/01/2017.
 */
public class InitJavaBeanDeserializerTest extends TestCase {
    ParserConfig config = new ParserConfig();

    protected void setUp() throws Exception {
        assertFalse(config.isAutoTypeSupport());

        Properties properties = new Properties();
        properties.put(ParserConfig.AUTOTYPE_SUPPORT_PROPERTY, "false");
        // config.addAccept("com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest11.EasyThreadModel");
        // -ea -Dfastjson.parser.autoTypeAccept=com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest9
        config.configFromPropety(properties);

        assertFalse(config.isAutoTypeSupport());
    }

    public void test_desktop() throws Exception {
        DenyTest11.Model model = new DenyTest11.Model();
        model.a = new DenyTest11.B();
        String text = "{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.deser.deny.InitJavaBeanDeserializerTest$EasyThreadModel\"}";

        Exception error = null;
        try {
            Object obj = JSON.parseObject(text, Object.class, config);
            System.out.println(obj.getClass());
        } catch (JSONException ex) {
            error = ex;
        }
        assertNotNull(error);

        config.initJavaBeanDeserializers(Model.class);

        Object obj = JSON.parseObject(text, Object.class, config);
        assertEquals(Model.class, obj.getClass());
    }

    public static class Model {

    }
}
