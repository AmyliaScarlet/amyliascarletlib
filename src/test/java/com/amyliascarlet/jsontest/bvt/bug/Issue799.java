package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenshao on 16/8/30.
 */
public class Issue799 extends TestCase {
    public void test_for_issue() throws Exception {
        String path = "$.array[0:-1].bizData";

        Map<String, Object> root = new HashMap<String, Object>();
        Object val = JSONPath.eval(root, path);
        assertNull(val);
    }
}
