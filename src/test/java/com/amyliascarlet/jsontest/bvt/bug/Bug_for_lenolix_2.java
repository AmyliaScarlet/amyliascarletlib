package com.amyliascarlet.jsontest.bvt.bug;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.TypeReference;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class Bug_for_lenolix_2 extends TestCase {

    public void test_0() throws Exception {
        Map<String, User> matcherMap = new HashMap<String, User>();
        String matcherMapString = JSON.toJSONString(matcherMap, SerializerFeature.WriteMapNullValue);

        System.out.println(matcherMapString);

        matcherMap = JSONObject.parseObject(matcherMapString, new TypeReference<Map<String, User>>() {
        });
    }

    public static class User {

    }
}
