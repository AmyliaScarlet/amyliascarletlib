package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSONArray;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

/**
 * Created by wenshao on 09/03/2017.
 */
public class JSONPath_array_remove_0 extends TestCase {
    public void test_remove() throws Exception {
        JSONObject jsonObject = new JSONObject();

        JSONArray array = new JSONArray();
        for (int i = 0; i < 10; ++i) {
            JSONObject item = new JSONObject();
            item.put("age", i);
            array.add(item);
        }
        jsonObject.put("aaa", array);

        JSONPath.remove(jsonObject, "$.aaa[0:1].age"); //解析出错
        JSONPath.remove(jsonObject, "$.aaa[0,1].age"); //解析出错
        JSONPath.remove(jsonObject, "$.aaa[0].age"); //解析正确
    }
}
