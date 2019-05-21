package com.amyliascarlet.jsontest.bvt.bug;

import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.util.IOUtils;

public class Issue72 extends TestCase {

    public void test_for_issue() throws Exception {
        InputStream is = Issue72.class.getClassLoader().getResourceAsStream("issue72.json");
        JSONReader reader = null;
        try {
            byte[] rowBatchBytes = null;
            byte[] fileBatchBytes = null;
            reader = new JSONReader(new InputStreamReader(is));
            reader.startArray();
            while (reader.hasNext()) {
                if (rowBatchBytes == null) {
                    rowBatchBytes = reader.readObject(byte[].class);
                } else if (fileBatchBytes == null) {
                    fileBatchBytes = reader.readObject(byte[].class);
                } else {
                    throw new Exception("archive data jsontest parse failed!");
                }

            }
            reader.endArray();
        } finally {
            IOUtils.close(reader);
        }
    }
}
