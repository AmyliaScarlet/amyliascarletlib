package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;


public class Bug_for_JSONObject extends TestCase {
    public void test_0 () throws Exception {
        JSONSerializer ser = new JSONSerializer();
        ser.config(SerializerFeature.WriteClassName, true);
        ser.write(new JSONObject());
    }
}
