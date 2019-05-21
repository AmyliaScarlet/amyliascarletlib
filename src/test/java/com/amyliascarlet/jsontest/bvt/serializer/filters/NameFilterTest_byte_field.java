package com.amyliascarlet.jsontest.bvt.serializer.filters;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.NameFilter;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;

public class NameFilterTest_byte_field extends TestCase {

    public void test_namefilter() throws Exception {
        NameFilter filter = new NameFilter() {

            public String process(Object source, String name, Object value) {
                if (value != null) {
                    Assert.assertTrue(value instanceof Byte);
                }
                
                if (name.equals("id")) {
                    return "ID";
                }

                return name;
            }

        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getNameFilters().add(filter);

        Bean a = new Bean();
        serializer.write(a);

        String text = out.toString();
        Assert.assertEquals("{\"ID\":0}", text);
    }

    public void test_namefilter_1() throws Exception {
        NameFilter filter = new NameFilter() {

            public String process(Object source, String name, Object value) {
                if (name.equals("id")) {
                    return "ID";
                }

                return name;
            }

        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getNameFilters().add(filter);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", (byte) 0);
        serializer.write(map);

        String text = out.toString();
        Assert.assertEquals("{\"ID\":0}", text);
    }

    public static class Bean {

        public byte    id;
        public String name;


    }
}
