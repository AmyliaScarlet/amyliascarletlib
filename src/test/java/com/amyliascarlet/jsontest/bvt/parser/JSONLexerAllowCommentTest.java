package com.amyliascarlet.jsontest.bvt.parser;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.parser.JSONReaderScanner;

public class JSONLexerAllowCommentTest extends TestCase {
    public void test_0() throws Exception {
        
        String jsonWithComment = "{ /*tes****\n\r\n*t*/\"a\":1 /*****test88888*****/ /*test*/ , /*test*/ //test\n //est\n \"b\":2}";
        JSONObject object = JSON.parseObject(jsonWithComment, Feature.AllowComment, Feature.OrderedField);
        System.out.println(object.toJSONString());
        Assert.assertEquals("{\"a\":1,\"b\":2}",object.toJSONString());

        DefaultJSONParser parser = new DefaultJSONParser(new JSONReaderScanner(jsonWithComment,
            Feature.AllowComment.getMask() | Feature.OrderedField.getMask()));
        
        JSONObject object1 = parser.parseObject();
        Assert.assertEquals("{\"a\":1,\"b\":2}",object1.toJSONString());
        System.out.println(object1.toJSONString());

    }

    public void test_1() throws IOException {
        String resource = "json/json_with_comment.json";
        InputStream is = Thread.currentThread().getContextClassLoader()
            .getResourceAsStream(resource);
        String text = IOUtils.toString(is);
        is.close();

        JSONObject object = JSON.parseObject(text, Feature.AllowComment, Feature.OrderedField);
        System.out.println(object.toJSONString());

        Assert
            .assertEquals(
                "{\"hello\":\"asafsadf\",\"test\":1,\"array\":[\"10000sfsaf\",100,{\"nihao\":{\"test\":\"sdfasdf\"}}],\"object\":{\"teset\":1000}}",
                object.toJSONString());
    }
}
