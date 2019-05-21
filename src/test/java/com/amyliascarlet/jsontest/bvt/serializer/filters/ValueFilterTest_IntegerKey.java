package com.amyliascarlet.jsontest.bvt.serializer.filters;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.ValueFilter;

import junit.framework.TestCase;

public class ValueFilterTest_IntegerKey extends TestCase {

    public void test_namefilter() throws Exception {
        ValueFilter filter = new ValueFilter() {

            public Object process(Object source, String name, Object value) {
                if (name.equals("1001")) {
                    return "wenshao";
                }

                return value;
            }

        };


        Map map = new HashMap();
        map.put(1001, 0);
        
        String text = JSON.toJSONString(map, filter);

        Assert.assertEquals("{1001:\"wenshao\"}", text);
    }

}
