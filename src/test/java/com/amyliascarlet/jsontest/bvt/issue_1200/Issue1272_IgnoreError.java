package com.amyliascarlet.jsontest.bvt.issue_1200;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

/**
 * Created by wenshao on 18/06/2017.
 */
public class Issue1272_IgnoreError extends TestCase {
    public void test_for_issue() throws Exception {
        String text = JSON.toJSONString(new Point(), SerializerFeature.IgnoreErrorGetter);
        assertEquals("{}", text);
    }

    public static class Point {

        private Long userId;

        public long getUserId() {
            return userId;
        }
    }
}
