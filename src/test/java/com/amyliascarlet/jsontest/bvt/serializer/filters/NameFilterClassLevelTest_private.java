package com.amyliascarlet.jsontest.bvt.serializer.filters;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.NameFilter;
import com.amyliascarlet.lib.json.serializer.PascalNameFilter;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;

import junit.framework.TestCase;

public class NameFilterClassLevelTest_private extends TestCase {

    public void test_0() throws Exception {
        Object[] array = { new ModelA(), new ModelB() };

        SerializeConfig config = new SerializeConfig();
        config.addFilter(ModelA.class, //
                         new PascalNameFilter());
        config.addFilter(ModelB.class, //
                         new NameFilter() {
                             @Override
                             public String process(Object object, String name, Object value) {
                                 return name;
                             }
                         });
        String text2 = JSON.toJSONString(array, config);
        Assert.assertEquals("[{\"Id\":1001},{\"id\":1002}]", text2);

        String text = JSON.toJSONString(array);
        Assert.assertEquals("[{\"id\":1001},{\"id\":1002}]", text);

    }

    private static class ModelA {

        public int id = 1001;
    }

    private static class ModelB {

        public int id = 1002;
    }
}
