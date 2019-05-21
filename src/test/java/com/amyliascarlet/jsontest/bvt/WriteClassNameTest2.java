package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest2 extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.WriteClassNameTest2");
    }

    public void test_0() throws Exception {
        Entity entity = new Entity(3, "jobs");
        String text = JSON.toJSONString(entity, SerializerFeature.WriteClassName, SerializerFeature.PrettyFormat);
        System.out.println(text);
        
        Entity entity2 = (Entity) JSON.parseObject(text, Object.class);
        
        Assert.assertEquals(entity.getId(), entity2.getId());
        Assert.assertEquals(entity.getName(), entity2.getName());
    }

    public static class Entity {

        private int    id;
        private String name;

        public Entity(){
        }

        public Entity(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
