package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

/**
 * Created by wenshao on 2016/11/18.
 */
public class Issue900_1 extends TestCase {
    public void test_for_issue() throws Exception {
        Model model = JSON.parseObject("{\"id\":123}", Model.class);
        assertEquals(123, model.id);
    }

    @JSONType(parseFeatures = Feature.SupportNonPublicField)
    public static class Model {
        private int id;
    }
}
