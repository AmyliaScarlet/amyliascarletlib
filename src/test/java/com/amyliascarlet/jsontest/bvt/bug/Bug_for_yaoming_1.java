package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.bvtVO.AccessHttpConfigModel;


public class Bug_for_yaoming_1 extends TestCase {
    public void test_0 () throws Exception {
        JSON.parseObject("{}", AccessHttpConfigModel.class);
    }
}
