package com.amyliascarlet.jsontest.bvt.parser.deser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.LongCodec;

public class LongDeserializerTest extends TestCase {

    public void test_bigdecimal() throws Exception {
        Assert.assertEquals(0, JSON.parseObject("0", Long.class).intValue());
        Assert.assertEquals(0, JSON.parseObject("0.0", Long.class).intValue());
        Assert.assertEquals(0, JSON.parseObject("'0'", Long.class).intValue());

        Assert.assertEquals(null, JSON.parseObject("null", Long.class));

        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Assert.assertEquals(null, LongCodec.instance.deserialze(parser, null, null));
        Assert.assertEquals(JSONToken.LITERAL_INT, LongCodec.instance.getFastMatchToken());
    }
}
