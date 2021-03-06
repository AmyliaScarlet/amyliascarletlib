package com.amyliascarlet.jsontest.bvt.stream;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONWriter;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class JSONWriterTest_3 extends TestCase {

    public void test_writer() throws Exception {
        StringWriter out = new StringWriter();
        JSONWriter writer = new JSONWriter(out);
        writer.config(SerializerFeature.UseSingleQuotes, true);
        writer.startObject();
        
        writer.startObject();
        writer.endObject();

        writer.startObject();
        writer.endObject();
        
        writer.endObject();
        writer.close();

        Assert.assertEquals("{{}:{}}", out.toString());
    }
}
