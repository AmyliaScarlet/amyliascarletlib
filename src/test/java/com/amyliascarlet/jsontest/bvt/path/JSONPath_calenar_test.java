package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

import java.util.Calendar;

public class JSONPath_calenar_test extends TestCase {
    public void test_map() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_MONTH, 30);

        calendar.set(Calendar.HOUR_OF_DAY, 16);
        calendar.set(Calendar.MINUTE, 8);
        calendar.set(Calendar.SECOND, 43);

        assertEquals(2017, JSONPath.eval(calendar, "/year"));
        assertEquals(6, JSONPath.eval(calendar, "/month"));
        assertEquals(30, JSONPath.eval(calendar, "/day"));

        assertEquals(16, JSONPath.eval(calendar, "/hour"));
        assertEquals(8, JSONPath.eval(calendar, "/minute"));
        assertEquals(43, JSONPath.eval(calendar, "/second"));


    }
}
