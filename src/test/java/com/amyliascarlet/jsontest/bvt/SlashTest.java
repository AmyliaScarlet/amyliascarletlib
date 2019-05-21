package com.amyliascarlet.jsontest.bvt;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

public class SlashTest extends TestCase {
    public void test_0 () throws Exception {
        String text = "{\"errorMessage\":\"resource '/rpc/hello/none.jsontest' is not found !\"}";
        JSONObject json = (JSONObject) JSON.parse(text);
        
        Assert.assertEquals("{\"errorMessage\":\"resource '/rpc/hello/none.jsontest' is not found !\"}", json.toString());
    }
}
