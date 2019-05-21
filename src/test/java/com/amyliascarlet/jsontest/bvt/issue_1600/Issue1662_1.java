package com.amyliascarlet.jsontest.bvt.issue_1600;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;
import junit.framework.TestCase;

import java.io.IOException;
import java.lang.reflect.Type;

public class Issue1662_1 extends TestCase {
    public void test_for_issue() throws Exception {
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

        public Integer deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
            Object val = parser.parse();
            return ((Integer) val).intValue() * 100;
        }

        public int getFastMatchToken() {
            return 0;
        }
    }
}
