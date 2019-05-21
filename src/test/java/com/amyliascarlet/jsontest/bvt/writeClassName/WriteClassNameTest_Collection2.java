package com.amyliascarlet.jsontest.bvt.writeClassName;

import java.util.Collection;
import java.util.Collections;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest_Collection2 extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Collection2");
    }

    public void test_list() throws Exception {
        A a = new A();
        a.setList(Collections.singletonList(new B()));
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Collection2$A\",\"list\":[{}]}",
                            text);

        A a1 = (A) JSON.parse(text);

        Assert.assertEquals(1, a1.getList().size());
        Assert.assertTrue(a1.getList().iterator().next() instanceof B);
    }

    public static class A {

        private Collection<B> list;

        public Collection<B> getList() {
            return list;
        }

        public void setList(Collection<B> list) {
            this.list = list;
        }

    }

    public static final class B {

    }
}
