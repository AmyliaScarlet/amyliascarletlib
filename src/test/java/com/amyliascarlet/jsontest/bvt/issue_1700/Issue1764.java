package com.amyliascarlet.jsontest.bvt.issue_1700;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;

import static com.amyliascarlet.lib.json.serializer.SerializerFeature.BrowserCompatible;

public class Issue1764 extends TestCase {
    public void test_for_issue() throws Exception {
        Model model = new Model();
        model.value = 9007199254741992L;

        String str = JSON.toJSONString(model);
        assertEquals("{\"value\":\"9007199254741992\"}", str);
    }

    public static class Model {
        @JSONField(serialzeFeatures = BrowserCompatible)
        public long value;
    }
}
