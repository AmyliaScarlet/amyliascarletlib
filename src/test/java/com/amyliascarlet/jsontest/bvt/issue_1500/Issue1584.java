package com.amyliascarlet.jsontest.bvt.issue_1500;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;
import junit.framework.TestCase;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

public class Issue1584 extends TestCase {
    public void test_for_issue() throws Exception {
        ParserConfig config = new ParserConfig();

        String json = "{\"k\":1,\"v\":\"A\"}";

        {
            Map.Entry entry = JSON.parseObject(json, Map.Entry.class, config);
            assertEquals("v", entry.getKey());
            assertEquals("A", entry.getValue());
        }

        config.putDeserializer(Map.Entry.class, new ObjectDeserializer() {
            public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
                JSONObject object = parser.parseObject();
                Object k = object.get("k");
                Object v = object.get("v");

                return (T) Collections.singletonMap(k, v).entrySet().iterator().next();
            }

            public int getFastMatchToken() {
                return 0;
            }
        });

        Map.Entry entry = JSON.parseObject(json, Map.Entry.class, config);
        assertEquals(1, entry.getKey());
        assertEquals("A", entry.getValue());
    }
}
