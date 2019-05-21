package com.amyliascarlet.jsontest.bvt.parser.creator;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.annotation.JSONCreator;
import com.amyliascarlet.lib.json.annotation.JSONField;

import junit.framework.TestCase;

public class JSONCreatorTest5 extends TestCase {

    public void test_create_error() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"id\":1001,\"name\":\"wenshao\",\"obj\":{\"$ref\":\"$\"}}", Entity.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }

    public static class Entity {

        private final int    id;
        private final String name;
        private final Entity obj;
        
        private Entity(int id, String name, Entity obj) {
            this.id = id;
            this.name = name;
            this.obj = obj;
        }
        
        @JSONCreator
        public static Entity create(@JSONField(name = "id") int id, @JSONField(name = "name") String name,
                      Entity obj){
            return new Entity(id, name, obj);
        }


        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Entity getObj() {
            return obj;
        }

    }

}