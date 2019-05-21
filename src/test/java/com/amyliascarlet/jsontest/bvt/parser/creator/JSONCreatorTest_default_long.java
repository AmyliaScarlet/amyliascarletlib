package com.amyliascarlet.jsontest.bvt.parser.creator;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONCreator;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;
import org.junit.Assert;

public class JSONCreatorTest_default_long extends TestCase {

    public void test_create() throws Exception {
        Model model = JSON.parseObject("{\"name\":\"wenshao\"}", Model.class);
        Assert.assertEquals(0, model.id);
        Assert.assertEquals("wenshao", model.name);
    }


    public static class Model {

        private final long id;
        private final String name;

        @JSONCreator
        public Model(@JSONField(name="id") long id, @JSONField(name="name") String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Value {

    }
}
