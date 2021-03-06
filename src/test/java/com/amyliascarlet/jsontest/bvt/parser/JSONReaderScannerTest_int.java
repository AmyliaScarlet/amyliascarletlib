package com.amyliascarlet.jsontest.bvt.parser;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSONArray;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONReaderScanner;

public class JSONReaderScannerTest_int extends TestCase {

    public void test_scanInt() throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append('[');
        for (int i = 0; i < 1024; ++i) {
            if (i != 0) {
                buf.append(',');
            }
            buf.append(i);
        }
        buf.append(']');

        Reader reader = new StringReader(buf.toString());

        JSONReaderScanner scanner = new JSONReaderScanner(reader);

        DefaultJSONParser parser = new DefaultJSONParser(scanner);
        JSONArray array = (JSONArray) parser.parse();
        for (int i = 0; i < array.size(); ++i) {
            Assert.assertEquals(i, ((Integer) array.get(i)).intValue()); 
        }
    }
}
