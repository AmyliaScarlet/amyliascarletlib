package com.amyliascarlet.jsontest.bvt.stream;

import java.io.StringWriter;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONWriter;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class JSONWriterTest_6 extends TestCase {

    public void test_writer() throws Exception {
        StringWriter out = new StringWriter();
        JSONWriter writer = new JSONWriter(out);
        writer.config(SerializerFeature.WriteNullStringAsEmpty, true);

        writer.startObject();
        writer.writeKey("value");
        writer.writeObject((String) null);
        writer.endObject();

        writer.close();

        Assert.assertEquals("{\"value\":\"\"}", out.toString());
    }
}
