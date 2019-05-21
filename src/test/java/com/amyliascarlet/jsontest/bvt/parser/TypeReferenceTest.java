package com.amyliascarlet.jsontest.bvt.parser;

import java.util.List;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.TypeReference;

public class TypeReferenceTest extends TestCase {

    public void test_list() throws Exception {
        List<Long> list = JSON.parseObject("[1,2,3]", new TypeReference<List<Long>>() {});
        Assert.assertEquals(1L, ((Long) list.get(0)).longValue());
    }
}
