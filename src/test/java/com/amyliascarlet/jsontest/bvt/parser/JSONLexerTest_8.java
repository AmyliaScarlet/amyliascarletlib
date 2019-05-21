package com.amyliascarlet.jsontest.bvt.parser;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.parser.JSONReaderScanner;
import com.amyliascarlet.lib.json.parser.JSONScanner;
import com.amyliascarlet.lib.json.parser.JSONToken;

public class JSONLexerTest_8 extends TestCase {

    public void test_ident() throws Exception {
        JSONScanner lexer = new JSONScanner("123");
        lexer.nextIdent();
        org.junit.Assert.assertEquals(JSONToken.LITERAL_INT, lexer.token());
        lexer.close();
    }

    public void test_ident_2() throws Exception {
        JSONScanner lexer = new JSONScanner("\uFEFF123");
        lexer.nextIdent();
        org.junit.Assert.assertEquals(JSONToken.LITERAL_INT, lexer.token());
        lexer.close();
    }
    
    public void test_ident_3() throws Exception {
        JSONReaderScanner lexer = new JSONReaderScanner("\uFEFF123");
        lexer.nextIdent();
        org.junit.Assert.assertEquals(JSONToken.LITERAL_INT, lexer.token());
        lexer.close();
    }
}
