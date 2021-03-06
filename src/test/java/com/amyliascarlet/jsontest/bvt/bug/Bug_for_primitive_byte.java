package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class Bug_for_primitive_byte extends TestCase {

    public void test_emptyStr() throws Exception {
        JSON.parseObject("{\"value\":\"\"}", VO.class);
    }
    
    public void test_null() throws Exception {
        JSON.parseObject("{\"value\":null}", VO.class);
    }
    
    public void test_strNull() throws Exception {
        JSON.parseObject("{\"value\":\"null\"}", VO.class);
    }

    public static class VO {

        private byte value;

        public byte getValue() {
            return value;
        }

        public void setValue(byte value) {
            throw new UnsupportedOperationException();
        }

    }
}
