package com.amyliascarlet.jsontest.bvt.basicType;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

public class BigInteger_BrowserCompatible extends TestCase {
    public void test_for_issue() throws Exception {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("id1", 9223370018640066466L);
        map.put("id2", new BigInteger("9223370018640066466"));
        assertEquals("{\"id1\":\"9223370018640066466\",\"id2\":\"9223370018640066466\"}",
                JSON.toJSONString(map, SerializerFeature.BrowserCompatible)
        );
    }
}
