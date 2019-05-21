package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import junit.framework.TestCase;

/**
 * Created by wenshao on 29/01/2017.
 */
public class DenyTest12 extends TestCase {
    public void test_deny() throws Exception {
        String text = "{\"value\":{\"@type\":\"java.lang.EasyThread\"}}";

        Exception error = null;
        try {
            JSON.parseObject(text, Model.class);
        } catch (JSONException ex) {
            error = ex;
        }
        assertNotNull(error);
    }

    public static class Model {
        public Value value;
    }

    public static class Value {

    }
}
