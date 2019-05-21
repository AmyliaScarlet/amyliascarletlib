package com.amyliascarlet.jsontest.bvt.serializer.stream;

import java.io.StringWriter;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;


public class StreamWriterTest_writeBytes1 extends TestCase {
    public void test_0() throws Exception {
        StringWriter out = new StringWriter();
        
        byte[] bytes = "民主共和君主宪".getBytes("GB2312");
        SerializeWriter writer = new SerializeWriter(out, 10);
        Assert.assertEquals(10, writer.getBufferLength());
        
        writer.writeByteArray(bytes);
        writer.close();
        
        String text = out.toString();
        byte[] result = JSON.parseObject(text, byte[].class);
        Assert.assertEquals("民主共和君主宪", new String(result, "GB2312"));
    }
}
