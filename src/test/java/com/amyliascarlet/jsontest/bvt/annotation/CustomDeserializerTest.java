package com.amyliascarlet.jsontest.bvt.annotation;

import java.lang.reflect.Type;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;

import junit.framework.TestCase;

public class CustomDeserializerTest extends TestCase {
    public void test_0() throws Exception {
        String text = "{\"xid\":1001}";
        Model model = JSON.parseObject(text, Model.class);
        Assert.assertEquals(1001, model.id);
    }
    
    @JSONType(deserializer=ModelDeserializer.class)
    public static class Model {
        public int id;
    }
    
    public static class ModelDeserializer implements ObjectDeserializer {
        @Override
        public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
            JSONReader reader = new JSONReader(parser);
            
            reader.startObject();
            
            String key = reader.readString();
            Integer value = reader.readInteger();
            
            Model model = new Model();
            model.id = value;
            
            reader.endObject();
            // TODO Auto-generated method stub
            return (T) model;
        }

        @Override
        public int getFastMatchToken() {
            return 0;
        }
        
    }
}
