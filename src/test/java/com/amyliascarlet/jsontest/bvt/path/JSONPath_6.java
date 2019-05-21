package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

public class JSONPath_6 extends TestCase {

    public void test_path() throws Exception {
        String json = "{\"hello\":\"world\"}";
        JSONObject object = JSON.parseObject(json);
        assertTrue(JSONPath.contains(object, "$.hello"));
        assertTrue(JSONPath.contains(object, "hello"));
    }

//    public void test_path_2() throws Exception {
////        File file = new File("/Users/wenshao/Downloads/test");
////        String jsontest = FileUtils.readFileToString(file);
//        String jsontest = "{\"returnObj\":[{\"$ref\":\"$.subInvokes.com\\\\.alipay\\\\.cif\\\\.user\\\\.UserInfoQueryService\\\\@findUserInfosByCardNo\\\\(String[])[0].response[0]\"}]}";
//        JSON.parseObject(jsontest);
//    }

}
