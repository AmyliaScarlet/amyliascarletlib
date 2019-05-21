package com.amyliascarlet.jsontest.bvt;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;

public class JSONObjectTest4 extends TestCase {

    public void test_interface() throws Exception {
        VO vo = JSON.parseObject("{id:123}", VO.class);
        Assert.assertEquals(123, vo.getId());
    }

    public static interface VO {
        @JSONField()
        int getId();

        @JSONField()
        void setId(int val);
    }
}
