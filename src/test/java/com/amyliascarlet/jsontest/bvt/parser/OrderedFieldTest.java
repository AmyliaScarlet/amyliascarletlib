package com.amyliascarlet.jsontest.bvt.parser;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.Feature;

import junit.framework.TestCase;

public class OrderedFieldTest extends TestCase {
    public void test_ordered_field() throws Exception {
        String text = "{\"id\":1001}";
        Model model = JSON.parseObject(text, Model.class, Feature.OrderedField);
        Assert.assertEquals(1001, model.getId());
        String text2 = JSON.toJSONString(model);
        Assert.assertEquals(text, text2);
        
    }
    
    public static interface Model {
        public int getId();
        public void setId(int value);
    }
}
