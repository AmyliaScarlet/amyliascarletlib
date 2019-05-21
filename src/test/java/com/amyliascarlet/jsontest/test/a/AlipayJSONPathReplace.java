package com.amyliascarlet.jsontest.test.a;

import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

/**
 * Created by wenshao on 06/02/2017.
 */
public class AlipayJSONPathReplace extends TestCase {
    public void test_jsonpath() throws Exception {
        Model model = new Model();
        JSONPath path = JSONPath.compile("/value/id");
        path.set(model, 123);
        assertNotNull(model.value);
    }

    public static class Model {
        public Value value;
    }

    public static class Value {
        public int id;
    }
}
