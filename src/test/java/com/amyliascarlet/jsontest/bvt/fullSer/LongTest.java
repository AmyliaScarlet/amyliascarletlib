package com.amyliascarlet.jsontest.bvt.fullSer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import org.junit.Assert;
import junit.framework.TestCase;

public class LongTest extends TestCase {

    public void test_0() throws Exception {
        
        VO vo = new VO();
        vo.setValue(33L);
        
        String text = JSON.toJSONString(vo, SerializerFeature.WriteClassName);
        System.out.println(text);
        
        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.fullSer.LongTest$VO\",\"value\":33}", text);
    }

    public static class VO {

        private Long value;

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }
    }
}
