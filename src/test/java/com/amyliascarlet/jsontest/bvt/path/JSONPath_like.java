package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;


public class JSONPath_like extends TestCase {
    public void test_like_not_match() throws Exception {
        assertNull(
                JSONPath.read("{\"table\":\"_order_base\"}", "[table LIKE 'order_base%']"));
    }

    public void test_like_not_match_1() throws Exception {
        assertEquals("{\"table\":\"_order_base\"}",
                JSONPath.read("{\"table\":\"_order_base\"}", "[table LIKE '_order_base%']").toString());
    }

}
