package com.amyliascarlet.jsontest.bvt.fullSer;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class getfTest_2 extends TestCase {

    public void test_codec() throws Exception {
        VO vo = new VO();
        vo.setfFlag(true);

        String text = JSON.toJSONString(vo);
        Assert.assertEquals("{\"fFlag\":true}", text);
        VO vo1 = JSON.parseObject(text, VO.class);
        Assert.assertEquals(true, vo1.isfFlag());
    }

    public static class VO {

        private boolean fFlag;

        public boolean isfFlag() {
            return fFlag;
        }

        public void setfFlag(boolean fFlag) {
            this.fFlag = fFlag;
        }

    }
}
