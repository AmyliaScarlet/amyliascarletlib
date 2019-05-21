package com.amyliascarlet.jsontest.bvt.parser;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.JSONScanner;
import com.amyliascarlet.lib.json.parser.JSONToken;

public class JSONScannerTest_isEOF extends TestCase {

    public void test_0() throws Exception {
        String text = "{}  ";
        JSONObject obj = JSON.parseObject(text);
        Assert.assertEquals(0, obj.size());
    }

    public void test_1() throws Exception {
        JSONScanner lexer = new JSONScanner("  ");
        lexer.nextToken();
        Assert.assertTrue(lexer.token() == JSONToken.EOF);
    }

    public void test_2() throws Exception {
        JSONScanner lexer = new JSONScanner("1  ");
        lexer.nextToken();
        lexer.nextToken();
        Assert.assertTrue(lexer.token() == JSONToken.EOF);
    }

    public void test_3() throws Exception {
        JSONScanner lexer = new JSONScanner(" {}");
        lexer.nextToken();
        Assert.assertTrue(lexer.token() != JSONToken.EOF);
    }

}
