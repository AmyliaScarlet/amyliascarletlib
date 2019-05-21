package com.amyliascarlet.jsontest.bvt;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class TabCharTest extends TestCase {

    @SuppressWarnings("deprecation")
    public void test_0() throws Exception {
        JSONObject json = new JSONObject();
        json.put("hello\t", "World\t!");
        Assert.assertEquals("{\"hello\\t\":\"World\\t!\"}", JSON.toJSONString(json));
        Assert.assertEquals("{\"hello\\t\":\"World\\t!\"}", JSON.toJSONStringZ(json, SerializeConfig.getGlobalInstance()));
        Assert.assertEquals("{'hello\\t':'World\\t!'}", JSON.toJSONString(json, SerializerFeature.WriteTabAsSpecial, SerializerFeature.UseSingleQuotes));
    }

}
