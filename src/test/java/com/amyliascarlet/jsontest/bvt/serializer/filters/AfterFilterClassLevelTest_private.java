package com.amyliascarlet.jsontest.bvt.serializer.filters;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AfterFilter;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;

import junit.framework.TestCase;

public class AfterFilterClassLevelTest_private extends TestCase {

    public void test_0() throws Exception {
        Object[] array = { new ModelA(), new ModelB() };

        SerializeConfig config = new SerializeConfig();
        config.addFilter(ModelA.class, //
                         new AfterFilter() {

                             @Override
                             public void writeAfter(Object object) {
                                 this.writeKeyValue("type", "A");
                             }
                         });
        config.addFilter(ModelB.class, //
                         new AfterFilter() {

                             @Override
                             public void writeAfter(Object object) {
                                 this.writeKeyValue("type", "B");
                             }
                         });
        String text2 = JSON.toJSONString(array, config);
        Assert.assertEquals("[{\"id\":1001,\"type\":\"A\"},{\"id\":1002,\"type\":\"B\"}]", text2);

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
