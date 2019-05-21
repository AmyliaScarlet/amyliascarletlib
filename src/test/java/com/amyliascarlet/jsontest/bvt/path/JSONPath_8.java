package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONPath;
import com.amyliascarlet.lib.json.JSONPathException;
import junit.framework.TestCase;

import java.util.Map;

public class JSONPath_8 extends TestCase {

    public void test_path() throws Exception {
        Model m = new Model();
        m.f0 = 101;
        m.f1 = 102;

        JSONPath.remove(m, "$.f0");
        assertNull(m.f0);

        JSONPath.remove(m, "$.f1");
        assertNull(m.f1);


        JSONPath.remove(m, "$.f2");

        JSONPath.eval(m, "$.f2");
    }

    public void test_error() throws Exception {
        Exception error = null;

        Model m = new Model();
        m.f0 = 101;
        m.f1 = 102;

        try {
            JSONPath.eval(m, "$.id");
        } catch (JSONPathException ex) {
            error = ex;
        }
        assertNotNull(error);
    }

    public void test_error_1() throws Exception {
        Exception error = null;

        Model m = new Model();
        m.f0 = 101;
        m.f1 = 102;

        try {
            JSONPath.eval(m, "$..id");
        } catch (JSONPathException ex) {
            error = ex;
        }
        assertNotNull(error);
    }

    public void test_paths() throws Exception {
        Model m = new Model();
        m.f0 = 101;
        m.f1 = 102;

        Exception error = null;
        try {
            Map<String, Object> paths = JSONPath.paths(m);
        } catch (JSONException ex) {
            error = ex;
        }
        assertNotNull(error);
    }

    public static class Model {
        public Integer f0;
        public Integer f1;

        public Integer getId() {
            throw new IllegalStateException();
        }

    }

//    public void test_path_2() throws Exception {
////        File file = new File("/Users/wenshao/Downloads/test");
////        String jsontest = FileUtils.readFileToString(file);
//        String jsontest = "{\"returnObj\":[{\"$ref\":\"$.subInvokes.com\\\\.alipay\\\\.cif\\\\.user\\\\.UserInfoQueryService\\\\@findUserInfosByCardNo\\\\(String[])[0].response[0]\"}]}";
//        JSON.parseObject(jsontest);
//    }

}
