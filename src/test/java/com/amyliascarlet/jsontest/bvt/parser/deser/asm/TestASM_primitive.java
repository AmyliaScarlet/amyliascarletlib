package com.amyliascarlet.jsontest.bvt.parser.deser.asm;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.ASMDeserializerFactory;
import com.amyliascarlet.lib.json.util.ASMClassLoader;
import com.amyliascarlet.lib.json.util.JavaBeanInfo;

import junit.framework.TestCase;

public class TestASM_primitive extends TestCase {

    public void test_asm() throws Exception {

        ASMDeserializerFactory factory = new ASMDeserializerFactory(new ASMClassLoader());
        Exception error = null;
        try {
            JavaBeanInfo beanInfo = JavaBeanInfo.build(int.class, int.class, null);
            factory.createJavaBeanDeserializer(ParserConfig.getGlobalInstance(), beanInfo);
        } catch (Exception ex) {
            error = ex;
        }
        assertNotNull(error);
    }

}
