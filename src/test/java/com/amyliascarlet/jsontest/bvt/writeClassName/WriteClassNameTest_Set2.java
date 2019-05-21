package com.amyliascarlet.jsontest.bvt.writeClassName;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest_Set2 extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set2");
    }

    public void test_list() throws Exception {
        A a = new A();
        Set<B> set = new LinkedHashSet<B>();
        set.add(new B());
        set.add(new B1());
        a.setList(set);
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
//        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set2$A\",\"list\":[{},{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Set2$B1\"}]}",
//                            text);

        ParserConfig parserConfig = new ParserConfig();
        parserConfig.addAccept("com.amyliascarlet.jsontest.bvt");
        A a1 = (A) JSON.parseObject(text, Object.class, parserConfig);

        Assert.assertEquals(2, a1.getList().size());
        Assert.assertTrue("B", new ArrayList<B>(a1.getList()).get(0) instanceof B || new ArrayList<B>(a1.getList()).get(0) instanceof B1);
        Assert.assertTrue("B1", new ArrayList<B>(a1.getList()).get(1) instanceof B || new ArrayList<B>(a1.getList()).get(1) instanceof B1);
    }

    private static class A {

        private Set<B> list;

        public Set<B> getList() {
            return list;
        }

        public void setList(Set<B> list) {
            this.list = list;
        }

    }

    private static class B {

    }

    private static class B1 extends B {

    }
}
