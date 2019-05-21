package com.amyliascarlet.jsontest.bvt.parser;

import java.util.List;

import org.junit.Assert;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class ReadOnlyCollectionTest extends TestCase {
    
    public void test_readOnlyNullList() throws Exception {
        String text = "{\"list\":[]}";
        Entity entity = JSON.parseObject(text, Entity.class);
        Assert.assertNotNull(entity);
    }

    public static class Entity {

        private List<Object> list;

        public List<Object> getList() {
            return list;
        }

    }
}
