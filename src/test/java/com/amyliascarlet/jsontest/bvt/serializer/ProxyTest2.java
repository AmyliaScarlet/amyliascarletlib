package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

/**
 * Created by wenshao on 07/08/2017.
 */
public class ProxyTest2 extends TestCase {
    public void test_0() throws Exception {
        Model model = JSON.parseObject("{\"id\":1001}", Model.class);
        Model model2 = JSON.parseObject("{\"id\":1001}", Model.class);
        System.out.println(model.getId());

//        System.out.println(model.getClass());
//        System.out.println(model2.getClass());

        assertEquals("{\"id\":1001}", JSON.toJSONString(model));
        assertEquals("{\"id\":1001}", JSON.toJSONString(model));

    }

    public static interface Model {
        int getId();
        void setId(int val);
    }
}
