package com.amyliascarlet.jsontest.bvt.parser.deser;

import java.util.TreeSet;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class TreeSetFieldTest extends TestCase {

    public void test_null() throws Exception {
        Entity value = JSON.parseObject("{value:null}", Entity.class);
        Assert.assertNull(value.getValue());
    }

    public void test_empty() throws Exception {
        Entity value = JSON.parseObject("{value:[]}", Entity.class);
        Assert.assertEquals(0, value.getValue().size());
    }

    private static class Entity {

        private TreeSet value;

        public TreeSet getValue() {
            return value;
        }

        public void setValue(TreeSet value) {
            this.value = value;
        }
    }
}
