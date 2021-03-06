package com.amyliascarlet.jsontest.bvt.parser.deser;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.MiscCodec;

import junit.framework.TestCase;

public class URIDeserializerTest extends TestCase {

    public void test_null() throws Exception {
        String input = "null";
        DefaultJSONParser parser = new DefaultJSONParser(input, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);

        MiscCodec deser = new MiscCodec();
        Assert.assertEquals(JSONToken.LITERAL_STRING, deser.getFastMatchToken());

        Assert.assertNull(deser.deserialze(parser, null, null));
    }

}
