package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

public class JSONObjectOrderTest extends TestCase {
    public void test_for_order() throws Exception {
        System.out.println(JSON.VERSION);
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put("code","code");
        jsonObj.put("msg","msg");
        jsonObj.put("data", "data");
        String jsonStr = JSON.toJSONString(jsonObj, SerializerFeature.MapSortField);
        assertEquals("{\"code\":\"code\",\"msg\":\"msg\",\"data\":\"data\"}", jsonStr);
    }
}
