package com.amyliascarlet.jsontest.bvt.writeClassName;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest_Set3 extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set3");
    }

    public void test_list() throws Exception {
        A a = new A();
        LinkedHashSet<B> set = new LinkedHashSet<B>();
        set.add(new B());
        set.add(new B1());
        a.setList(set);
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
//        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set3$A\",\"list\":[{},{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set3$B1\"}]}",
//                            text);

        A a1 = (A) JSON.parse(text);

        Assert.assertEquals(2, a1.getList().size());
        Assert.assertTrue(new ArrayList<B>(a1.getList()).get(0) instanceof B);
        Assert.assertTrue(new ArrayList<B>(a1.getList()).get(1) instanceof B1);
    }

    private static class A {

        private LinkedHashSet<B> list;

        public LinkedHashSet<B> getList() {
            return list;
        }

        public void setList(LinkedHashSet<B> list) {
            this.list = list;
        }

    }

    private static class B {

    }

    private static class B1 extends B {

    }
}
