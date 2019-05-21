package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;
import junit.framework.TestCase;

/**
 * Created by wenshao on 01/04/2017.
 */
public class MaxBufSizeTest extends TestCase {
    public void test_max_buf() throws Exception {
        SerializeWriter writer = new SerializeWriter();

        Throwable error = null;
        try {
            writer.setMaxBufSize(1);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
    }
}
