package com.amyliascarlet.jsontest.bvt.writeClassName;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import junit.framework.TestCase;

/**
 * Created by wenshao on 14/08/2017.
 */
public class WriteClassNameTest6 extends TestCase {
    public void test_for_writeClassName() throws Exception {
        String json = "{\"@type\":\"java.util.HashMap\",\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest6$EasyThreadModel\",\"id\":1001}";

        Model model = (Model) JSON.parse(json);
        assertNotNull(model);
    }

    public void test_for_writeClassName_1() throws Exception {
        String json = "{\"@type\":\"java.util.HashMap\",\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest6$EasyThreadModel\",\"id\":1001}";

        Model model = JSON.parseObject(json, Model.class);
        assertNotNull(model);
    }

    @JSONType
    public static class Model {
        public int id;
    }


}
