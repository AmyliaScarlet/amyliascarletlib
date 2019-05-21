package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import java.util.Properties;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.ParserConfig;

import junit.framework.TestCase;

public class DenyTest3 extends TestCase {

    public void test_0() throws Exception {
        String text = "{}";

        ParserConfig config = new ParserConfig();

        Properties properties = new Properties();
        properties.put(ParserConfig.DENY_PROPERTY, "com.amyliascarlet.jsontest.bvtVO.deny,,aa");
        config.configFromPropety(properties);
        
        Exception error = null;
        try {
            JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvtVO.deny$A\"}", Object.class, config, JSON.DEFAULT_PARSER_FEATURE);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
        
        JSON.parseObject(text, B.class, config, JSON.DEFAULT_PARSER_FEATURE);
    }
    
    public static class B {
        
    }

}
