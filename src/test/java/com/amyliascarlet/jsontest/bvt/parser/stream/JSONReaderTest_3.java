package com.amyliascarlet.jsontest.bvt.parser.stream;

import java.io.StringReader;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONReader;

import junit.framework.TestCase;

public class JSONReaderTest_3 extends TestCase {

    public void test_read_Long() throws Exception {
        String text = "1001";
        JSONReader reader = new JSONReader(new StringReader(text));

        Exception error = null;
        try {
            reader.hasNext();
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
}
