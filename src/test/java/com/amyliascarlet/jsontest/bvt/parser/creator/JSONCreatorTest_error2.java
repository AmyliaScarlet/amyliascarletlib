package com.amyliascarlet.jsontest.bvt.parser.creator;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.annotation.JSONCreator;
import com.amyliascarlet.lib.json.annotation.JSONField;

public class JSONCreatorTest_error2 extends TestCase {

    public void test_create() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"id\":123,\"name\":\"abc\"}", Entity.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }

    public static class Entity {

        private final int    id;
        private final String name;
        
        private Entity(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @JSONCreator
        public static Entity create(@JSONField(name = "id") int id, @JSONField(name = "name") String name){
            throw new UnsupportedOperationException();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }

}
