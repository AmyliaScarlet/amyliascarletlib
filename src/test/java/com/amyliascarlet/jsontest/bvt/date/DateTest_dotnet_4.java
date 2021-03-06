package com.amyliascarlet.jsontest.bvt.date;

import java.util.Date;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class DateTest_dotnet_4 extends TestCase {

    public void test_date() throws Exception {
        String text = "{\"date\":\"/Date(1461081600321+5000)/\"}";

        JSONObject model = JSON.parseObject(text);
        Assert.assertEquals(1461081600321L, ((java.util.Date) model.getObject("date", java.util.Date.class)).getTime());
    }

    private static class Model {

        private Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }
}
