package com.amyliascarlet.jsontest.bvt.issue_1000;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import junit.framework.TestCase;

/**
 * Created by wenshao on 17/03/2017.
 */
public class Issue1082 extends TestCase {
    public void test_for_issue() throws Exception {
        Throwable error = null;
        try {
            JSON.parseObject("{}", Model_1082.class);
        } catch (JSONException ex) {
            error = ex;
        }
        assertNotNull(error);
    }

    public class Model_1082 {

    }
}
