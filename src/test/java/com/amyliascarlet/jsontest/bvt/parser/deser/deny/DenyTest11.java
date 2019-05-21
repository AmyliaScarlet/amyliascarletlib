package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

import java.util.Properties;

public class DenyTest11 extends TestCase {
    ParserConfig config = new ParserConfig();

    protected void setUp() throws Exception {
        assertFalse(config.isAutoTypeSupport());

        Properties properties = new Properties();
        properties.put(ParserConfig.AUTOTYPE_SUPPORT_PROPERTY, "false");
        config.addAccept("com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest11.EasyThreadModel");
        // -ea -Dfastjson.parser.autoTypeAccept=com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest9
        config.configFromPropety(properties);

        assertFalse(config.isAutoTypeSupport());

        config.clearDeserializers();
    }

    public void test_autoTypeDeny() throws Exception {
        Model model = new Model();
        model.a = new B();
        String text = JSON.toJSONString(model, SerializerFeature.WriteClassName);
        System.out.println(text);

        Object obj = JSON.parseObject(text, Object.class, config);
        assertEquals(Model.class, obj.getClass());
    }
    
    public static class Model {
        public A a;
    }

    public static class Model2 {
        public A a;
    }

    public static class A {

    }

    public static class B extends A {

    }
}
