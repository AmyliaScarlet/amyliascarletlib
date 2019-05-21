package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.ParserConfig;

import junit.framework.TestCase;

public class DenyTest extends TestCase {

    public void test_0() throws Exception {
        String text = "{}";

        ParserConfig config = new ParserConfig();

        config.addDeny(null);
        config.addDeny("com.amyliascarlet.jsontest.bvtVO.deny");

        Exception error = null;
        try {
            JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvtVO.deny$A\"}", Object.class, config, JSON.DEFAULT_PARSER_FEATURE);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
        
        JSON.parseObject(text, B.class, config, JSON.DEFAULT_PARSER_FEATURE);
    }

    public void test_1() throws Exception {
        String text = "{}";

        ParserConfig config = new ParserConfig();

        config.addDeny(null);
        config.addDeny("com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest.B");

        Exception error = null;
        try {
            JSON.parseObject("{\"@type\":\"LLLcom.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest$B;;;\"}", Object.class, config, JSON.DEFAULT_PARSER_FEATURE);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);

        JSON.parseObject(text, B.class, config, JSON.DEFAULT_PARSER_FEATURE);
    }

    
  public static class B {
        
    }
}
