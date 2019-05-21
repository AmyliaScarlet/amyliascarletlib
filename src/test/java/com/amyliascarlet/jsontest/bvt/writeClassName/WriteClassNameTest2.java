package com.amyliascarlet.jsontest.bvt.writeClassName;

import com.amyliascarlet.lib.json.parser.Feature;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest2 extends TestCase {

    public void test_writeClassName() throws Exception {
        A a = new A();
        a.setB(new B());
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest2$A\",\"b\":{\"id\":0}}",
                            text);

        A a1 = (A) JSON.parse(text, Feature.SupportAutoType);

        Assert.assertNotNull(a1.getB());
    }

    public static class A {

        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

    }

    public static final class B {

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }
}
