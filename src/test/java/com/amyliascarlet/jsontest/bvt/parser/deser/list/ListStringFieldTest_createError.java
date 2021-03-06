package com.amyliascarlet.jsontest.bvt.parser.deser.list;

import java.io.StringReader;
import java.util.ArrayList;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.parser.Feature;

import junit.framework.TestCase;

public class ListStringFieldTest_createError extends TestCase {

    public void test_null() throws Exception {
        Exception error = null;
        try {
            String text = "{\"values\":[]}";
            JSON.parseObject(text, Model.class, Feature.SupportArrayToBean);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_reader() throws Exception {
        Exception error = null;
        try {
            String text = "{\"values\":[]}";
            JSONReader reader = new JSONReader(new StringReader(text));
            reader.readObject(Model.class);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }

    public static class Model {

        private MyErrorList<String> values;

        public MyErrorList<String> getValues() {
            return values;
        }

        public void setValues(MyErrorList<String> values) {
            this.values = values;
        }

    }

    public static class MyErrorList<T> extends ArrayList<T> {

        public MyErrorList(){
            throw new IllegalStateException();
        }
    }
}
