package com.amyliascarlet.jsontest.bvt.parser.deser;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created by wenshao on 25/03/2017.
 */
public class InnerClassDeser3 extends TestCase {
    public void test_for_inner_class() throws Exception {
        Model model = JSON.parseObject("{\"items\":{\"123\":{\"id\":123}}}", Model.class);
        assertNotNull(model.items);
        assertEquals(123, model.items.get("123").id);
    }

    public static class Model {
        public Map<String, Item> items;

        public class Item {
            public int id;
        }
    }
}
