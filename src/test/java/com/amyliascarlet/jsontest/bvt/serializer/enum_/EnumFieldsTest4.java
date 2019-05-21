package com.amyliascarlet.jsontest.bvt.serializer.enum_;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class EnumFieldsTest4 extends TestCase {
    public void test_enum() throws Exception {
        Model model = new Model();
        model.types = new Type[]{Type.A, null};
        
        String text = JSON.toJSONString(model, SerializerFeature.WriteMapNullValue);
        Assert.assertEquals("{\"types\":[\"A\",null]}", text);
    }
    
    public static class Model {
        public Type[] types;
    }

    private static enum Type {
                             A, B, C
    }
}
