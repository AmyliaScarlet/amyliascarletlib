package com.amyliascarlet.jsontest.bvt.parser.deser;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;

/**
 * Created by wenshao on 05/04/2017.
 */
public class JSONFieldSetterTest extends TestCase {
    public void test_for_setter() throws Exception {
        Model model = JSON.parseObject("{\"id\":123}", Model.class);
        assertEquals(123, model._id);
    }

    public static class Model {
        private int _id;

        @JSONField(name = "id")
        public void id(int id) {
            this._id = id;
        }
    }
}
