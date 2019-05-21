package com.amyliascarlet.jsontest.bvt.parser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.parser.ParseContext;


public class ParseContextTest extends TestCase {
    public void test_toString() throws Exception {
        Assert.assertEquals("$", new ParseContext(null, new Object(), "id").toString());
    }
}
