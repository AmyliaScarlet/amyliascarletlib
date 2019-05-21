package com.amyliascarlet.jsontest.bvt.serializer;

import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.PascalNameFilter;

public class PascalNameFilterTest_1 extends TestCase {

    public void test_0() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        serializer.getNameFilters().add(new PascalNameFilter());

        Map<String, Object> vo = new LinkedHashMap<String, Object>();
        vo.put("", 123);
        vo.put(null, "wenshao");

        serializer.write(vo);

        Assert.assertEquals("{\"\":123,null:\"wenshao\"}", serializer.toString());

        serializer.close();
    }

}
