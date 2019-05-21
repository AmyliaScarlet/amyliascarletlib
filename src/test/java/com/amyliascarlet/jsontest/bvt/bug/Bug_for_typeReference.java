package com.amyliascarlet.jsontest.bvt.bug;

import java.util.List;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.TypeReference;


public class Bug_for_typeReference extends TestCase {
    public void test_0 () throws Exception {
        String text = "[]";
        JSON.parseObject(text, new TypeReference<List<String>>(){}.getType());
    }
}
