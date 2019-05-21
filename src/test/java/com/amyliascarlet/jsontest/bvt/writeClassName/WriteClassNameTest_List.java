package com.amyliascarlet.jsontest.bvt.writeClassName;

import java.util.Collections;
import java.util.List;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class WriteClassNameTest_List extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_List");
    }

    public void test_list() throws Exception {
        A a = new A();
        a.setList(Collections.singletonList(new B()));
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);
        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_List$A\",\"list\":[{}]}",
                            text);

        A a1 = (A) JSON.parse(text);

        Assert.assertEquals(1, a1.getList().size());
        Assert.assertTrue(a1.getList().get(0) instanceof B);
    }

    private static class A {

        private List<B> list;

        public List<B> getList() {
            return list;
        }

        public void setList(List<B> list) {
            this.list = list;
        }

    }

    private static final class B {

    }
}
