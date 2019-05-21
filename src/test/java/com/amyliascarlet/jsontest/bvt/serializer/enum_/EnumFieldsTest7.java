package com.amyliascarlet.jsontest.bvt.serializer.enum_;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.lib.json.serializer.ValueFilter;

import junit.framework.TestCase;

public class EnumFieldsTest7 extends TestCase {

    public void test_enum() throws Exception {
        Model model = new Model();
        model.t1 = Type.A;
        model.t2 = null;

        ValueFilter filter = new ValueFilter() {
            public Object process(Object object, String name, Object value) {
                return null;
            }
        };
        String text = JSON.toJSONString(model, filter, SerializerFeature.WriteMapNullValue);
        Assert.assertEquals("{\"t1\":null,\"t2\":null}", text);
    }

    public static class Model {

        private Type t1;
        private Type t2;

        public Type getT1() {
            return t1;
        }

        public void setT1(Type t1) {
            this.t1 = t1;
        }

        public Type getT2() {
            return t2;
        }

        public void setT2(Type t2) {
            this.t2 = t2;
        }

    }

    private static enum Type {
                              A, B, C
    }
}
