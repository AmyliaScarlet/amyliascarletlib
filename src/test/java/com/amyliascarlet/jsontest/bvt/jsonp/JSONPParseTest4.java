package com.amyliascarlet.jsontest.bvt.jsonp;

import com.amyliascarlet.lib.json.JSONPObject;
import junit.framework.TestCase;

/**
 * Created by wenshao on 21/02/2017.
 */
public class JSONPParseTest4 extends TestCase {
    public void test_f() throws Exception {
        JSONPObject p = new JSONPObject();
        p.setFunction("f");
        assertEquals("f()", p.toJSONString());
    }
}
