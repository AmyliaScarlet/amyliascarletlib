package com.amyliascarlet.jsontest.bvt.serializer;

import java.io.StringWriter;
import java.util.Collections;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class SerializeWriterTest_8 extends TestCase {

    public void test_BrowserCompatible() throws Exception {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 1024; ++i) {
            buf.append('a');
        }
        buf.append("中国");
        buf.append("\0");
        JSON.toJSONString(buf.toString(), SerializerFeature.BrowserCompatible);
    }

    public void test_writer() throws Exception {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 1024; ++i) {
            buf.append('a');
        }
        buf.append("中国");
        buf.append("\0");

        StringWriter out = new StringWriter();
        JSON.writeJSONStringTo(buf.toString(), out, SerializerFeature.BrowserCompatible);
    }

    public void test_singleQuote() throws Exception {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 1024; ++i) {
            buf.append('a');
        }
        buf.append("中国");
        buf.append("\0");

        SerializeWriter out = new SerializeWriter(new StringWriter());

        try {
            JSONSerializer serializer = new JSONSerializer(out);
            serializer.config(SerializerFeature.QuoteFieldNames, false);
            serializer.config(SerializerFeature.UseSingleQuotes, true);

            serializer.write(Collections.singletonMap(buf.toString(), ""));
        } finally {
            out.close();
        }
    }

    public void test_singleQuote_writer() throws Exception {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 1024; ++i) {
            buf.append('a');
        }
        buf.append("中国");
        buf.append("\0");

        StringWriter out = new StringWriter();
        JSON.writeJSONStringTo(Collections.singletonMap(buf.toString(), ""), out, SerializerFeature.UseSingleQuotes);
    }
}
