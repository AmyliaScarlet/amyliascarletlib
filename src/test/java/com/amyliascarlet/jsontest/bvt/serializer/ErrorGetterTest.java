package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import junit.framework.TestCase;

public class ErrorGetterTest extends TestCase {

    public void test_0() throws Exception {
        Model m = new Model();

        Exception error = null;
        try {
            JSON.toJSONString(m);
        } catch (JSONException ex) {
            error = ex;
        }
        assertNotNull(error);
    }

    private static class Model {
        public int getValue() {
            throw new UnsupportedOperationException();
        }
    }
}
