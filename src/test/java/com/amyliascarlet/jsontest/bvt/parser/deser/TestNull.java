package com.amyliascarlet.jsontest.bvt.parser.deser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.NumberDeserializer;
import com.amyliascarlet.lib.json.serializer.CharacterCodec;

public class TestNull extends TestCase {

    public void test_byte() throws Exception {
        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);

        Assert.assertNull(new NumberDeserializer().deserialze(parser, null, null));
    }
    
    public void test_char() throws Exception {
        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        
        Assert.assertNull(new CharacterCodec().deserialze(parser, null, null));
    }
    
    public void test_short() throws Exception {
        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        
        Assert.assertNull(new NumberDeserializer().deserialze(parser, null, null));
    }
    
    public void test_null() throws Exception {
        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        
        Assert.assertNull(new NumberDeserializer().deserialze(parser, null, null));
    }
}
