package com.amyliascarlet.jsontest.bvt.parser.deser;

import java.util.TreeMap;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class TreeMapDeserializerTest extends TestCase {
    public void test_0 () throws Exception {
        TreeMap treeMap = JSON.parseObject("{}", TreeMap.class);
        Assert.assertEquals(0, treeMap.size());
    }
}
