package com.amyliascarlet.jsontest.bvt.writeAsArray;

import java.io.StringReader;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class WriteAsArray_string_special_Reader extends TestCase {

    
    public void test_0() throws Exception {
        Model model = new Model();
        model.name = "a\\bc";
        String text = JSON.toJSONString(model, SerializerFeature.BeanToArray);
        Assert.assertEquals("[\"a\\\\bc\"]", text);

        JSONReader reader = new JSONReader(new StringReader(text));
        reader.config(Feature.SupportArrayToBean, true);
        Model model2 = reader.readObject(Model.class);
        Assert.assertEquals(model.name, model2.name);
        reader.close();
    }
    
    public void test_1() throws Exception {
        Model model = new Model();
        model.name = "a\\bc\"";
        String text = JSON.toJSONString(model, SerializerFeature.BeanToArray);
        Assert.assertEquals("[\"a\\\\bc\\\"\"]", text);

        JSONReader reader = new JSONReader(new StringReader(text));
        reader.config(Feature.SupportArrayToBean, true);
        Model model2 = reader.readObject(Model.class);
        Assert.assertEquals(model.name, model2.name);
        reader.close();
    }

    public static class Model {

        public String name;

    }
}
