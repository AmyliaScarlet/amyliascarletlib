package com.amyliascarlet.jsontest.bvt.parser.array;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class BeanToArrayTest3 extends TestCase {

    public void test_array() throws Exception {
        Model model = new Model();
        model.item = new Item();
        model.item.id = 1001;
        
        String text = JSON.toJSONString(model);
        
        Assert.assertEquals("{\"item\":[1001]}", text);
        
        Model model2 = JSON.parseObject(text, Model.class);
        Assert.assertEquals(model2.item.id, model.item.id);
    }
   
    public static class Model {
        @JSONField(serialzeFeatures=SerializerFeature.BeanToArray, parseFeatures=Feature.SupportArrayToBean)
        public Item item;
    }
    
    public static class Item {
        public int id;
    }
}
