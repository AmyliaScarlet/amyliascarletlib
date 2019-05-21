package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

public class TestSpecial_4 extends TestCase {

    public void test_special() throws Exception {
        String json = "{\"大小\":123}";
        JSONObject object = JSON.parseObject(json);
        Object obj = JSONPath.eval(object, "$.大小");
        assertEquals(123, obj);
    }

}
