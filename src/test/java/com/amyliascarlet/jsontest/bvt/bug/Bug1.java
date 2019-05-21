package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.jsontest.bvt.bug.JSONTest.InnerEntry;
import com.amyliascarlet.jsontest.bvt.bug.JSONTest.OuterEntry;

public class Bug1 extends TestCase {

    public void testToEntry2() {
        InnerEntry inner1 = null;// 出错
        String source1 = JSONObject.toJSONString(inner1);
        System.out.println(source1);
        OuterEntry inner2 = JSONObject.parseObject(source1, OuterEntry.class);// 出错
    }
}
