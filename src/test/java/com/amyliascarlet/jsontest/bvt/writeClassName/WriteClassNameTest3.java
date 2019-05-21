package com.amyliascarlet.jsontest.bvt.writeClassName;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class WriteClassNameTest3 extends TestCase {


    public void test_list() throws Exception {
        Map root = new HashMap();
        root.put("val", new Model());

        String str = JSON.toJSONString(root);
        assertEquals("{\"val\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest3$EasyThreadModel\"}}", str);

       JSON.parseObject(str);
    }

    @JSONType(serialzeFeatures = SerializerFeature.WriteClassName)
    public static final class Model {
        public String value;
    }
}
