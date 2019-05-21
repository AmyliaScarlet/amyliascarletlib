package com.amyliascarlet.jsontest.bvt.util;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

import java.util.LinkedHashMap;

public class TypeUtilsCastLinkedHashMap extends TestCase {
    public void test_for_cast() throws Exception {
        JSONObject obj = JSON.parseObject("{\"id\":1001,\"name\":\"xxx\"}", Feature.OrderedField);
        obj.toJavaObject(LinkedHashMap.class);
    }
}
