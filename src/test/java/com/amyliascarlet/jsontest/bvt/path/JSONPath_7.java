package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSONArray;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

public class JSONPath_7 extends TestCase {

    public void test_path() throws Exception {
        Model[] array = new Model[] {new Model(101), new Model(202), new Model(303)};
        JSONArray values = (JSONArray) JSONPath.eval(array, "$.id");
        assertEquals(101, values.get(0));
        assertEquals(202, values.get(1));
        assertEquals(303, values.get(2));

        assertEquals(3, JSONPath.eval(array, "$.length"));
    }

    public static class Model {
        public int id;

        public Model(int id) {
            this.id = id;
        }
    }

//    public void test_path_2() throws Exception {
////        File file = new File("/Users/wenshao/Downloads/test");
////        String jsontest = FileUtils.readFileToString(file);
//        String jsontest = "{\"returnObj\":[{\"$ref\":\"$.subInvokes.com\\\\.alipay\\\\.cif\\\\.user\\\\.UserInfoQueryService\\\\@findUserInfosByCardNo\\\\(String[])[0].response[0]\"}]}";
//        JSON.parseObject(jsontest);
//    }

}
