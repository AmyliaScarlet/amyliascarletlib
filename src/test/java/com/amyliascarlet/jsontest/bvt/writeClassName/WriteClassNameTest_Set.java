package com.amyliascarlet.jsontest.bvt.writeClassName;

import java.util.LinkedHashSet;
import java.util.Set;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest_Set extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set");
    }

    public void test_list() throws Exception {
        A a = new A();
        Set<B> set = new LinkedHashSet<B>();
        set.add(new B());
        set.add(new B1());
        a.setList(set);
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set$A\",\"list\":[{},{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set$B1\"}]}",
                            text);

        A a1 = (A) JSON.parse(text);

        Assert.assertEquals(2, a1.getList().size());
    }

    public static class A {

        private Set<B> list;

        public Set<B> getList() {
            return list;
        }

        public void setList(Set<B> list) {
            this.list = list;
        }

    }

    public static class B {

    }

    public static class B1 extends B {

    }
}
