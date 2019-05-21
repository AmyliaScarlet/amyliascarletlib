package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.util.TypeUtils;
import junit.framework.TestCase;

/**
 * Created by wenshao on 29/01/2017.
 */
public class DenyTest16 extends TestCase {
    public void test_deny() throws Exception {
        JSONObject object = new JSONObject();
        object.put("@type", "com.mchange.v2.c3p0.impl.PoolBackedDataSourceBase");

        Throwable error = null;
        try {
            TypeUtils.castToJavaBean(object, Object.class);
        } catch (Exception ex) {
            error = ex;
        }
        assertNotNull(error);
    }

    public static class Model {
        public Throwable value;
    }
}
