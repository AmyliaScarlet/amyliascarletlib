package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.jsontest.bvtVO.BigClass;

import junit.framework.TestCase;

public class FastJsonBigClassTest extends TestCase {

    public void test_big_class() {
        BigClass bigObj = new BigClass();
        String json = JSON.toJSONString(bigObj, SerializerFeature.IgnoreNonFieldGetter);
//        assertThat(jsontest, not(containsString("skipme")));
    }

}
