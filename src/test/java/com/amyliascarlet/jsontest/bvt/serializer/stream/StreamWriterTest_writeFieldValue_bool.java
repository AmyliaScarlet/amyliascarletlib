package com.amyliascarlet.jsontest.bvt.serializer.stream;

import com.amyliascarlet.lib.json.serializer.SerializeWriter;

import junit.framework.TestCase;

import org.junit.Assert;

import java.io.StringWriter;


public class StreamWriterTest_writeFieldValue_bool extends TestCase {
    public void test_0() throws Exception {
        StringWriter out = new StringWriter();
        
        SerializeWriter writer = new SerializeWriter(out, 10);
        Assert.assertEquals(10, writer.getBufferLength());
        
        writer.writeFieldValue(',', "abcde01245abcde", true);
        writer.close();
        
        String text = out.toString();
        Assert.assertEquals(",abcde01245abcde:true", text);
    }
}
