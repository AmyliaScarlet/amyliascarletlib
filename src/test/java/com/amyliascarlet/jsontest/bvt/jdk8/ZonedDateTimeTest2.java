package com.amyliascarlet.jsontest.bvt.jdk8;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;
import org.junit.Assert;

import java.time.ZonedDateTime;

public class ZonedDateTimeTest2 extends TestCase {

    public void test_for_issue() throws Exception {
        VO vo = new VO();
        vo.date = ZonedDateTime.now();
        
        String text = JSON.toJSONString(vo);
        System.out.println(text);
        
        VO vo1 = JSON.parseObject(text, VO.class);
        
        Assert.assertEquals(vo.date.getSecond(), vo1.date.getSecond());
    }

    public static class VO {
        @JSONField(format="yyyy-MM-dd HH:mm:ss")
        public ZonedDateTime date;

    }
}
