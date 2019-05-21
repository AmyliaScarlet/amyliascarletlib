package com.amyliascarlet.jsontest.bvt;

import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.TypeReference;


public class MapTest2 extends TestCase {
    public void test_map () throws Exception {
Map<Object, Object> map = JSON.parseObject("{1:\"2\",\"3\":4,'5':6}", new TypeReference<Map<Object, Object>>() {});
Assert.assertEquals("2", map.get(1));
Assert.assertEquals(4, map.get("3"));
Assert.assertEquals(6, map.get("5"));
    }
}
