package com.amyliascarlet.jsontest.bvt.serializer.filters;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.BeanContext;
import com.amyliascarlet.lib.json.serializer.ContextValueFilter;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;

import junit.framework.TestCase;

public class ContextValueClassLevelTest extends TestCase {

    public void test_0() throws Exception {
        Object[] array = { new ModelA(), new ModelB() };

        SerializeConfig config = new SerializeConfig();
        config.addFilter(ModelA.class, //
                         new ContextValueFilter() {

                             public Object process(BeanContext context, Object object, String name, Object value) {
                                 return 30001;
                             }
                         });
        config.addFilter(ModelB.class, //
                         new ContextValueFilter() {

                             public Object process(BeanContext context, Object object, String name, Object value) {
                                 return 20001;
                             }
                         });
        String text2 = JSON.toJSONString(array, config);
        Assert.assertEquals("[{\"id\":30001},{\"id\":20001}]", text2);

        String text = JSON.toJSONString(array);
        Assert.assertEquals("[{\"id\":1001},{\"id\":1002}]", text);

    }

    public static class ModelA {

        public int id = 1001;
    }

    public static class ModelB {

        public int id = 1002;
    }
}
