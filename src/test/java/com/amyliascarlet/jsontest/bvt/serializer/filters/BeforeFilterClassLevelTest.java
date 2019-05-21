package com.amyliascarlet.jsontest.bvt.serializer.filters;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.BeforeFilter;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;

import junit.framework.TestCase;

public class BeforeFilterClassLevelTest extends TestCase {

    public void test_0() throws Exception {
        Object[] array = { new ModelA(), new ModelB() };

        SerializeConfig config = new SerializeConfig();
        config.addFilter(ModelA.class, //
                         new BeforeFilter() {

                             @Override
                             public void writeBefore(Object object) {
                                 this.writeKeyValue("type", "A");
                             }
                         });
        config.addFilter(ModelB.class, //
                         new BeforeFilter() {

                             @Override
                             public void writeBefore(Object object) {
                                 this.writeKeyValue("type", "B");
                             }
                         });
        String text2 = JSON.toJSONString(array, config);
        Assert.assertEquals("[{\"type\":\"A\",\"id\":1001},{\"type\":\"B\",\"id\":1002}]", text2);

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
