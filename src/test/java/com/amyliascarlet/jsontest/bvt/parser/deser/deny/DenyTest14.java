package com.amyliascarlet.jsontest.bvt.parser.deser.deny;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

/**
 * Created by wenshao on 29/01/2017.
 */
public class DenyTest14 extends TestCase {
    public void test_deny() throws Exception {
        String text = "{\"value\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.deser.deny.DenyTest14$MyException\"}}";
        Model model = JSON.parseObject(text, Model.class);
        assertTrue(model.value instanceof MyException);
    }

    public static class Model {
        public Throwable value;
    }

    public static class MyException extends Exception {

    }
}
