package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.serializer.ValueFilter;
import junit.framework.TestCase;

public class SerilaizeFilterTest extends TestCase {
    public void test_for_jsonField() throws Exception {
        Model m = new Model();
        String json = JSON.toJSONString(m);
        System.out.println(json);
    }

    public static class MyValueFilter implements ValueFilter {

        public Object process(Object object, String name, Object value) {
            if (name.equals("id")) {
                return 123;
            }

            return null;
        }
    }

    @JSONType(serialzeFilters = MyValueFilter.class)
    public static class Model {

        public int id;
    }
}
