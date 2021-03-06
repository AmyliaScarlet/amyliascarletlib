package com.amyliascarlet.jsontest.bvt.serializer.date;

import java.util.Date;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;


public class DateTest2 extends TestCase {
    
    public void test_null() throws Exception {
        long millis = System.currentTimeMillis();
        VO vo = new VO();
        vo.setValue(new Date(millis));
        
        Assert.assertEquals("new Date(" + millis + ")", JSON.toJSONString(new Date(millis), SerializerFeature.WriteClassName));
    }

    public static class VO {

        private Object value;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

    }
}
