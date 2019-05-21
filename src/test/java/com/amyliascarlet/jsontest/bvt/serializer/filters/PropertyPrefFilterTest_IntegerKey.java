package com.amyliascarlet.jsontest.bvt.serializer.filters;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.PropertyPreFilter;

import junit.framework.TestCase;

public class PropertyPrefFilterTest_IntegerKey extends TestCase {

    public void test_namefilter() throws Exception {
        PropertyPreFilter filter = new PropertyPreFilter() {

            public boolean apply(JSONSerializer serializer, Object object, String name) {
                return name.equals("1001");
            }

        };


        Map map = new HashMap();
        map.put(1001, 0);
        map.put(1002, 1);
        
        String text = JSON.toJSONString(map, filter);

        Assert.assertEquals("{1001:0}", text);
    }

}
