package com.amyliascarlet.jsontest.bvt.parser.deser;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.SqlDateDeserializer;

public class SqlDateDeserializerTest extends TestCase {

    public void test_bigdecimal() throws Exception {
        Assert.assertEquals(1309861159710L, JSON.parseObject("1309861159710", java.sql.Date.class).getTime());
        Assert.assertEquals(1309861159710L, JSON.parseObject("1309861159710.0", java.sql.Date.class).getTime());
        Assert.assertEquals(1309861159710L, JSON.parseObject("'1309861159710'", java.sql.Date.class).getTime());

        Assert.assertEquals(null, JSON.parseObject("null", Integer.class));

        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Assert.assertEquals(null, SqlDateDeserializer.instance.deserialze(parser, null, null));
        Assert.assertEquals(JSONToken.LITERAL_INT, SqlDateDeserializer.instance.getFastMatchToken());
    }
}

