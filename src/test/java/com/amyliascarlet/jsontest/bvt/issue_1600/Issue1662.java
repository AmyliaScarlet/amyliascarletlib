package com.amyliascarlet.jsontest.bvt.issue_1600;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;
import junit.framework.TestCase;

import java.io.IOException;
import java.lang.reflect.Type;

public class Issue1662 extends TestCase {
    public void test_for_issue() throws Exception {

        ParserConfig.getGlobalInstance().putDeserializer(Model.class, new ModelValueDeserializer());
        String json = "{\"value\":123}";
        Model model = JSON.parseObject(json, Model.class);
        assertEquals("{\"value\":\"12300元\"}",JSON.toJSONString(model));

    }

    public static class Model {
        @JSONField(serializeUsing = ModelValueSerializer.class, deserializeUsing = ModelValueDeserializer.class)
        public int value;
    }

    public static class ModelValueSerializer implements ObjectSerializer {
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                          int features) throws IOException {
            Integer value = (Integer) object;
            String text = value + "元";
            serializer.write(text);
        }
    }

    public static class ModelValueDeserializer implements ObjectDeserializer {

        public Model deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
            JSONObject obj = (JSONObject)parser.parse();
            Model model = new Model();
            model.value = obj.getInteger("value") * 100;
            return model;
        }

        public int getFastMatchToken() {
            return 0;
        }
    }
}
