package com.amyliascarlet.jsontest.bvt.jdk8;

import java.time.LocalTime;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class LocalTimeTest2 extends TestCase {

    public void test_for_issue() throws Exception {
        VO vo1 = JSON.parseObject("{\"date\":\"20:30:55\"}", VO.class);
        
        Assert.assertEquals(20, vo1.date.getHour());
        Assert.assertEquals(30, vo1.date.getMinute());
        Assert.assertEquals(55, vo1.date.getSecond());
    }

    public static class VO {

        public LocalTime date;


    }
}
