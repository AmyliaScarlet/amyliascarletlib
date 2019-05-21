package com.amyliascarlet.jsontest.bvt.basicType;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

import java.io.StringReader;

/**
 * Created by wenshao on 10/08/2017.
 */
public class LongNullTest extends TestCase {
    public void test_null() throws Exception {
        Model model = JSON.parseObject("{\"v1\":null,\"v2\":null}", Model.class);
        assertNotNull(model);
        assertNull(model.v1);
        assertNull(model.v2);
    }

    public void test_null_quote() throws Exception {
        Model model = JSON.parseObject("{\"v1\":\"null\",\"v2\":\"null\"}", Model.class);
        assertNotNull(model);
        assertNull(model.v1);
        assertNull(model.v2);
    }

    public void test_null_1() throws Exception {
        Model model = JSON.parseObject("{\"v1\":null ,\"v2\":null }", Model.class);
        assertNotNull(model);
        assertNull(model.v1);
        assertNull(model.v2);
    }

    public void test_null_1_quote() throws Exception {
        Model model = JSON.parseObject("{\"v1\":\"null\" ,\"v2\":\"null\" }", Model.class);
        assertNotNull(model);
        assertNull(model.v1);
        assertNull(model.v2);
    }

    public void test_null_array() throws Exception {
        Model model = JSON.parseObject("[\"null\" ,\"null\"]", Model.class, Feature.SupportArrayToBean);
        assertNotNull(model);
        assertNull(model.v1);
        assertNull(model.v2);
    }

    public void test_null_array_reader() throws Exception {
        JSONReader reader = new JSONReader(new StringReader("[\"null\" ,\"null\"]"), Feature.SupportArrayToBean);
        Model model = reader.readObject(Model.class);
        assertNotNull(model);
        assertNull(model.v1);
        assertNull(model.v2);
    }

    public void test_null_array_reader_1() throws Exception {
        JSONReader reader = new JSONReader(new StringReader("[null ,null]"), Feature.SupportArrayToBean);
        Model model = reader.readObject(Model.class);
        assertNotNull(model);
        assertNull(model.v1);
        assertNull(model.v2);
    }

    public static class Model {
        public Long v1;
        public Long v2;
    }
}
