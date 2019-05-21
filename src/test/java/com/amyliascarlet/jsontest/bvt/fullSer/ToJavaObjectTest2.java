package com.amyliascarlet.jsontest.bvt.fullSer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.TypeReference;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created by wenshao on 04/02/2017.
 */
public class ToJavaObjectTest2 extends TestCase {
    public void test_for_toJavaObject() throws Exception {
        JSONObject obj = JSON.parseObject("{\"model\":{\"id\":123}}");
        Map<String, Model> models = obj.toJavaObject(new TypeReference<Map<String, Model>>(){}.getType());
        assertEquals(123, models.get("model").id);
    }

    public static class Model {
        public int id;
    }
}
