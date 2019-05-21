package com.amyliascarlet.jsontest.bvt.writeClassName;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest extends TestCase {

    protected void setUp() throws Exception {
        com.amyliascarlet.lib.json.parser.ParserConfig.getGlobalInstance().addAccept(this.getClass().getName() + ".");
    }

    public void test_list() throws Exception {
        A a = new A();
        a.setB(new B());
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest$A\",\"b\":{}}", text);
        
        A a1 = (A) JSON.parse(text);
        
        Assert.assertNotNull(a1.getB());
    }

    private static class A {

        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

    }

    private static final class B {
        
    }
}
