package com.amyliascarlet.jsontest.bvt.jdk8;

import java.time.LocalDate;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class LocalDateTest3 extends TestCase {

    public void test_for_issue() throws Exception {
        VO vo = JSON.parseObject("{\"date\":\"2016-05-06\"}", VO.class);
        
        Assert.assertEquals(2016, vo.date.getYear());
        Assert.assertEquals(5, vo.date.getMonthValue());
        Assert.assertEquals(6, vo.date.getDayOfMonth());
    }

    public static class VO {
        public LocalDate date;

    }
}
