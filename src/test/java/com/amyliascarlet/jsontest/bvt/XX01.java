package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import junit.framework.TestCase;

/**
 * Created by wenshao on 14/08/2017.
 */
public class XX01 extends TestCase {
    public void test_for_xx() throws Exception {
        String text = "{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}";
        JSONObject test = JSON.parseObject(text);

        String text2 = test.toJSONString();
        assertEquals("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}:1}", text2);
    }
}
