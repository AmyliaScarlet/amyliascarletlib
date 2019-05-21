package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;
import com.amyliascarlet.lib.json.serializer.StringCodec;
import junit.framework.TestCase;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by wenshao on 08/01/2017.
 */
public class Issue963 extends TestCase {
    public void test_for_issue() throws Exception {
        Mock mock = JSON.parseObject("{\"type\":\"boolean\"}", Mock.class);
        assertEquals(EnumType.BOOLEAN, mock.getType());
    }

    public enum EnumType {
        BOOLEAN;
        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    public static class Mock {

        @JSONField(serializeUsing = EnumTypeCodec.class, deserializeUsing = EnumTypeCodec.class)
        private EnumType type;

        public EnumType getType() {
            return type;
        }

        public void setType(EnumType type) {
            this.type = type;
        }
    }

    public static class EnumTypeCodec implements ObjectSerializer, ObjectDeserializer {
        public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
            String uncasedSensitive = StringCodec.instance.deserialze(parser, type, fieldName);
            return (T) EnumType.valueOf(uncasedSensitive.toUpperCase());
        }

        public int getFastMatchToken() {
            return JSONToken.LITERAL_STRING;
        }

        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            SerializeWriter out = serializer.out;
            if (object == null) {
                out.writeNull();
                return;
            }
            StringCodec.instance.write(serializer, ((EnumType) object).name().toLowerCase(), fieldName, fieldType, features);
        }

    }
}
