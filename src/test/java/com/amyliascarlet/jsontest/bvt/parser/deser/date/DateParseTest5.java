package com.amyliascarlet.jsontest.bvt.parser.deser.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class DateParseTest5 extends TestCase {
    protected void setUp() throws Exception {
        JSON.defaultTimeZone = TimeZone.getTimeZone("Asia/Shanghai");
        JSON.defaultLocale = Locale.CHINA;
    }
    
    public void test_date() throws Exception {
        String text = "\"1979-07-14T13:07:23.456\"";
        Date date = JSON.parseObject(text, Date.class);
        Calendar calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
        calendar.setTime(date);
        
        Assert.assertEquals(1979, calendar.get(Calendar.YEAR));
        Assert.assertEquals(6, calendar.get(Calendar.MONTH));
        Assert.assertEquals(14, calendar.get(Calendar.DAY_OF_MONTH));
        
        Assert.assertEquals(13, calendar.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(7, calendar.get(Calendar.MINUTE));
        Assert.assertEquals(23, calendar.get(Calendar.SECOND));
        Assert.assertEquals(456, calendar.get(Calendar.MILLISECOND));
    }
}
