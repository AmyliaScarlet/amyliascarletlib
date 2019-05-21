package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class IgnoreNonFieldGetterTest2 extends TestCase {

    public void test_int() throws Exception {
        VO vo = new VO();
        vo.setId(123);
        
        String text = JSON.toJSONString(vo, SerializerFeature.IgnoreNonFieldGetter);
        Assert.assertEquals("{\"id\":123}", text);
        
    }

    private static class VO {

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNextId() {
            return id + 1;
        }
    }
}
