package com.amyliascarlet.jsontest.bvt.issue_1600;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.MapDeserializer;
import junit.framework.TestCase;
import org.apache.commons.collections4.map.*;

import java.lang.reflect.Type;
import java.util.Map;

public class Issue1653 extends TestCase {
    public void test_for_issue() throws Exception {
ParserConfig config = new ParserConfig();
MapDeserializer deserializer = new MapDeserializer() {
    public Map<Object, Object> createMap(Type type) {
        return new CaseInsensitiveMap();
    }
};
config.putDeserializer(Map.class, deserializer);

CaseInsensitiveMap<String, Object> root = (CaseInsensitiveMap) JSON.parseObject("{\"val\":{}}", Map.class, config, Feature.CustomMapDeserializer);
CaseInsensitiveMap subMap = (CaseInsensitiveMap) root.get("val");
assertEquals(0, subMap.size());
    }
}
