package com.amyliascarlet.jsontest.bvt.parser.deser;

import java.util.regex.Pattern;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.MiscCodec;

import junit.framework.TestCase;

public class PatternDeserializerTest extends TestCase {

    public void test_pattern() throws Exception {
        Assert.assertEquals(Pattern.compile("abc").pattern(), JSON.parseObject("'abc'", Pattern.class).pattern());

        Assert.assertEquals(null, JSON.parseObject("null", Pattern.class));

        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Assert.assertEquals(null, MiscCodec.instance.deserialze(parser, null, null));
        Assert.assertEquals(JSONToken.LITERAL_STRING, MiscCodec.instance.getFastMatchToken());
    }
}
