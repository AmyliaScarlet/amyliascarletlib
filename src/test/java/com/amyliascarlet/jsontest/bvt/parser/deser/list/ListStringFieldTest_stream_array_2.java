package com.amyliascarlet.jsontest.bvt.parser.deser.list;

import java.io.StringReader;
import java.util.List;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.parser.Feature;

import junit.framework.TestCase;

public class ListStringFieldTest_stream_array_2 extends TestCase {

    public void test_list() throws Exception {
        String text = "[[\"a\",null,\"b\",\"ab\\\\c\"],[]]";

        JSONReader reader = new JSONReader(new StringReader(text));
        Model model = reader.readObject(Model.class);
        Assert.assertEquals(4, model.values.size());
        Assert.assertEquals("a", model.values.get(0));
        Assert.assertEquals(null, model.values.get(1));
        Assert.assertEquals("b", model.values.get(2));
        Assert.assertEquals("ab\\c", model.values.get(3));
        
        Assert.assertEquals(0, model.values2.size());
    }
    
    public void test_list2() throws Exception {
        String text = "{\"values\":[\"a\",null,\"b\",\"ab\\\\c\"],\"values2\":[]}";

        JSONReader reader = new JSONReader(new StringReader(text));
        Model model = reader.readObject(Model.class);
        Assert.assertEquals(4, model.values.size());
        Assert.assertEquals("a", model.values.get(0));
        Assert.assertEquals(null, model.values.get(1));
        Assert.assertEquals("b", model.values.get(2));
        Assert.assertEquals("ab\\c", model.values.get(3));
        
        Assert.assertEquals(0, model.values2.size());
    }

    
    @JSONType(parseFeatures = Feature.SupportArrayToBean)
    public static class Model {

        public List<String> values;
        public List<String> values2;

    }
}
