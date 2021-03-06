package com.amyliascarlet.jsontest.bvt.fullSer;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class getfTest extends TestCase {

    public void test_codec() throws Exception {
        VO vo = new VO();
        vo.setfId(123);
        
        String text = JSON.toJSONString(vo);
        Assert.assertEquals("{\"fId\":123}", text);
        VO vo1 = JSON.parseObject(text, VO.class);
        Assert.assertEquals(123, vo1.getfId());
    }

    public static class VO {

        private int fId;

        
        public int getfId() {
            return fId;
        }

        
        public void setfId(int fId) {
            this.fId = fId;
        }

        
    }
}
