package com.amyliascarlet.jsontest.bvt.issue_2200;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.TypeReference;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Issue2253 extends TestCase {
    public void test_for_issue() throws Exception {
        List<Map<String, Object>> result = new ArrayList();
        result.add(new LinkedHashMap());
        result.get(0).put("3", 3);
        result.get(0).put("2", 2);
        result.get(0).put("7", 7);

        assertEquals("[{\"3\":3,\"2\":2,\"7\":7}]", JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));

        result = JSON.parseObject(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue), new TypeReference<List<Map<String, Object>>>() {}, Feature.OrderedField);

        assertEquals("[{\"3\":3,\"2\":2,\"7\":7}]", JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
    }
}
