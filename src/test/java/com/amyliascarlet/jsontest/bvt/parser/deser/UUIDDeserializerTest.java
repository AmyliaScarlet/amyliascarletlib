package com.amyliascarlet.jsontest.bvt.parser.deser;

import java.util.UUID;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.MiscCodec;

import junit.framework.TestCase;

public class UUIDDeserializerTest extends TestCase {

    public void test_url() throws Exception {
        UUID id = UUID.randomUUID();
        Assert.assertEquals(id, JSON.parseObject("'" + id.toString() + "'", UUID.class));

        Assert.assertEquals(null, JSON.parseObject("null", UUID.class));

        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Assert.assertEquals(null, MiscCodec.instance.deserialze(parser, null, null));
        Assert.assertEquals(JSONToken.LITERAL_STRING, MiscCodec.instance.getFastMatchToken());

    }

    public void test_url_error() throws Exception {
        JSONException ex = null;
        try {
            JSON.parseObject("'123'", UUID.class);
        } catch (JSONException e) {
            ex = e;
        }
        Assert.assertNotNull(ex);
    }
}
