package com.amyliascarlet.jsontest.bvt.parser;

import org.junit.Assert;

import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.deserializer.NumberDeserializer;
import com.amyliascarlet.lib.json.parser.deserializer.SqlDateDeserializer;
import com.amyliascarlet.lib.json.serializer.AtomicCodec;
import com.amyliascarlet.lib.json.serializer.CharacterCodec;
import com.amyliascarlet.lib.json.serializer.MiscCodec;
import com.amyliascarlet.lib.json.serializer.ObjectArrayCodec;

import junit.framework.TestCase;

public class FastMatchCheckTest extends TestCase {
    public void test_match() throws Exception {
        Assert.assertEquals(JSONToken.LBRACKET, AtomicCodec.instance.getFastMatchToken());
        Assert.assertEquals(JSONToken.LITERAL_STRING, MiscCodec.instance.getFastMatchToken());
        Assert.assertEquals(JSONToken.LITERAL_INT, NumberDeserializer.instance.getFastMatchToken());
        Assert.assertEquals(JSONToken.LITERAL_INT, SqlDateDeserializer.instance.getFastMatchToken());
        Assert.assertEquals(JSONToken.LBRACKET, ObjectArrayCodec.instance.getFastMatchToken());
        Assert.assertEquals(JSONToken.LITERAL_STRING, CharacterCodec.instance.getFastMatchToken());
    }
}
