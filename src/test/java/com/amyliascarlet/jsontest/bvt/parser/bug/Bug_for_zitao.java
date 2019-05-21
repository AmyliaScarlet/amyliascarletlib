package com.amyliascarlet.jsontest.bvt.parser.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.BeanContext;
import com.amyliascarlet.lib.json.serializer.ContextValueFilter;
import junit.framework.TestCase;

public class Bug_for_zitao extends TestCase {
    public void test_for_issue() throws Exception {
        Model m = new Model();
        ContextValueFilter v = new ContextValueFilter() {

            public Object process(BeanContext context, Object object, String name, Object value) {
                if (value == null && context != null && Number.class.isAssignableFrom(context.getFieldClass())) {
                    return -1;
                }
                return null;
            }
        };

        String json = JSON.toJSONString(m, v);
        assertEquals("{\"value\":-1}", json);
    }

    public static class Model {
        public Number value;
    }
}
