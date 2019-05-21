package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.bvtVO.PushMsg;


public class Bug_for_sankun extends TestCase {
    public void test_sankun() throws Exception {
        PushMsg bean = new PushMsg();
        JSON.toJSONString(bean);
    }
}
