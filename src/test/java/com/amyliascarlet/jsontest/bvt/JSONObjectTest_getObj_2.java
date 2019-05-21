package com.amyliascarlet.jsontest.bvt;

import java.lang.reflect.Type;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.TypeReference;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.util.TypeUtils;

import junit.framework.TestCase;

public class JSONObjectTest_getObj_2 extends TestCase {

    public void test_get_empty() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("value", "");
        Assert.assertEquals("", obj.get("value"));
        Assert.assertNull(obj.getObject("value", Model.class));
    }
    
    public void test_get_null() throws Exception {
        TypeUtils.cast("null", getType(), ParserConfig.getGlobalInstance());
        TypeUtils.cast("", getType(), ParserConfig.getGlobalInstance());
    }
    
    public static class Model {
        
    }
    
    public static <T> Type getType() {
        return new TypeReference<T[]>() {}.getType();
    }
}
