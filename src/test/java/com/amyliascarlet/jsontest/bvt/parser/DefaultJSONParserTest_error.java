package com.amyliascarlet.jsontest.bvt.parser;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.ParserConfig;

public class DefaultJSONParserTest_error extends TestCase {

    public void test_error_1() {
        String text = "{\"obj\":{}]}";
        char[] chars = text.toCharArray();
        DefaultJSONParser parser = new DefaultJSONParser(chars, chars.length, ParserConfig.getGlobalInstance(), 0);

        JSONException error = null;
        try {
            parser.parseObject();
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_error_2() {
        String text = "{\"obj\":[]]}";
        char[] chars = text.toCharArray();
        DefaultJSONParser parser = new DefaultJSONParser(chars, chars.length, ParserConfig.getGlobalInstance(), 0);

        JSONException error = null;
        try {
            parser.parseObject();
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_error_3() {
        String text = "{\"obj\":true]}";
        char[] chars = text.toCharArray();
        DefaultJSONParser parser = new DefaultJSONParser(chars, chars.length, ParserConfig.getGlobalInstance(), 0);

        JSONException error = null;
        try {
            parser.parseObject();
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
}
