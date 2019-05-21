package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class Bug_for_wsky extends TestCase {
    
    public void test_writeMapNull() throws Exception {
        JSON.parseObject(JSON.toJSONString(new MethodReturn(), SerializerFeature.WriteMapNullValue), MethodReturn.class);
    }

    public static class MethodReturn {

        public Object    ReturnValue;
        public Throwable Exception;
    }
}
