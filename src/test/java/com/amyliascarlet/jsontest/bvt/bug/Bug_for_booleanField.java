package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;

public class Bug_for_booleanField extends TestCase {

    public void test_boolean() throws Exception {
        Assert.assertEquals("{\"is-abc\":false}", JSON.toJSONString(new BooleanJson()));
        Assert.assertTrue(JSON.parseObject("{\"is-abc\":true}", BooleanJson.class).isAbc());
    }

    public static class BooleanJson {

        @JSONField(name = "is-abc")
        private boolean isAbc;

        public boolean isAbc() {
            return isAbc;
        }
        
        public void setAbc(boolean value) {
            this.isAbc = value;
        }
    }
}
