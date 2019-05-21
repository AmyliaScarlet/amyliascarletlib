package com.amyliascarlet.jsontest.bvt;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.annotation.JSONField;

import junit.framework.TestCase;

public class JSONObjectTest_get extends TestCase {

    public void test_get() throws Exception {
        JSONObject obj = JSON.parseObject("{id:123}");
        Assert.assertEquals(123, obj.getObject("id", Object.class));
    }

    public static interface VO {
        @JSONField()
        int getId();

        @JSONField()
        void setId(int val);
    }
}
