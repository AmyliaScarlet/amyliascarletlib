package com.amyliascarlet.jsontest.bvt.parser.deser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.TypeReference;

public class DefaultObjectDeserializerTest10 extends TestCase {

    public <T extends A> void test_1() throws Exception {
        T[] list = JSON.parseObject("[{}]", new TypeReference<T[]>() {
        });
        Assert.assertEquals(1, list.length);
        Assert.assertNotNull(list[0]);
        Assert.assertTrue(list[0] instanceof A);
    }

    public static class A {

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }
}
