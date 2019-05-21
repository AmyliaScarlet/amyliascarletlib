package com.amyliascarlet.jsontest.bvt.parser.deser;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.MiscCodec;
import com.amyliascarlet.lib.json.serializer.StringCodec;

import junit.framework.TestCase;

public class InetAddressDeserializerTest extends TestCase {

    public void test_null() throws Exception {
        String input = "null";
        DefaultJSONParser parser = new DefaultJSONParser(input, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);

        MiscCodec deser = new MiscCodec();

        Assert.assertNull(deser.deserialze(parser, null, null));
    }
    
    public void test_string_null() throws Exception {
        String input = "null";
        DefaultJSONParser parser = new DefaultJSONParser(input, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        
        StringCodec deser = new StringCodec();
        
        Assert.assertNull(deser.deserialze(parser, null, null));
    }

    public void test_error_0() throws Exception {
        String input = "'[&中国-^]'";
        DefaultJSONParser parser = new DefaultJSONParser(input, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);

        MiscCodec deser = new MiscCodec();

        Throwable error = null;

        Object value = null;
        try {
            value = deser.deserialze(parser, null, null);
        } catch (Throwable ex) {
            error = ex;
        }

        Assert.assertNotNull(error);
    }
}
