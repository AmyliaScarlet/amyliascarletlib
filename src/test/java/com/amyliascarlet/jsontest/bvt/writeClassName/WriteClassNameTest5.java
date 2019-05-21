package com.amyliascarlet.jsontest.bvt.writeClassName;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

/**
 * Created by wenshao on 14/08/2017.
 */
public class WriteClassNameTest5 extends TestCase {
    public void test_for_writeClassName() throws Exception {
        Model model = new Model();
        B b = new B();
        b.id = 1001;
        b.value = 2017;
        model.a = b;

        String str = JSON.toJSONString(model);
        System.out.println(str);
        assertEquals("{\"a\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest5$B\",\"id\":1001,\"value\":2017}}", str);

        Model model2 = JSON.parseObject(str, Model.class);
        assertTrue(model2.a instanceof B);
    }

    public void test_for_writeClassName_no() throws Exception {
        Model model = new Model();
        A a = new A();
        a.id = 1001;
        model.a = a;

        String str = JSON.toJSONString(model);
        System.out.println(str);
        assertEquals("{\"a\":{\"id\":1001}}", str);

        Model model2 = JSON.parseObject(str, Model.class);
        assertSame(A.class, model2.a.getClass());
    }

    public static class Model {
        @JSONField(serialzeFeatures = SerializerFeature.WriteClassName)
        public A a;
    }

    public static class A {
        public int id;
    }

    public static class B extends A {
        public int value;
    }
}
