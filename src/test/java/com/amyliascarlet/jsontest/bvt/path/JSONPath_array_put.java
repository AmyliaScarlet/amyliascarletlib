package com.amyliascarlet.jsontest.bvt.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONPath;

import junit.framework.TestCase;

public class JSONPath_array_put extends TestCase {

    public void test_put() throws Exception {
        Map<String, Object> root = new HashMap<String, Object>();
        List list = new ArrayList();
        root.put("values", list);

        JSONPath path = new JSONPath("$.values");
        path.arrayAdd(root, 123);
        path.arrayAdd(root, (Object[]) null);
        path.arrayAdd(root, new Object[0]);
        path.arrayAdd(null, new Object[] { 1 });

        Assert.assertEquals(1, list.size());
        Assert.assertEquals(123, ((Integer) list.get(0)).intValue());
    }

    public void test_set() throws Exception {
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[0]);
        list.add(new int[0]);

        JSONPath path = new JSONPath("$[0]");
        path.arrayAdd(list, 123);

        Assert.assertEquals(1, list.get(0).length);
        Assert.assertEquals(123, ((int[]) list.get(0))[0]);
    }

    public void test_set_2() throws Exception {
        Object[] list = new Object[2];
        list[0] = new int[0];
        list[0] = new int[0];

        JSONPath path = new JSONPath("$[0]");
        path.arrayAdd(list, 123);

        Assert.assertEquals(1, ((int[]) list[0]).length);
        Assert.assertEquals(123, ((int[]) list[0])[0]);
    }

    public void test_put_array_int() throws Exception {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("values", new int[0]);

        JSONPath path = new JSONPath("$.values");
        path.arrayAdd(root, 123);

        int[] array = (int[]) root.get("values");
        Assert.assertEquals(1, array.length);
        Assert.assertEquals(123, array[0]);
    }

    public void test_put_array_long() throws Exception {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("values", new long[0]);

        JSONPath path = new JSONPath("$.values");
        path.arrayAdd(root, 123);

        long[] array = (long[]) root.get("values");
        Assert.assertEquals(1, array.length);
        Assert.assertEquals(123, array[0]);
    }

    public void test_put_array_error_0() throws Exception {
        Exception error = null;
        try {
            JSONPath path = new JSONPath("$.values");
            path.arrayAdd(new Object(), 123);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_put_array_error_1() throws Exception {
        Exception error = null;
        try {
            JSONPath path = new JSONPath("$.values");
            path.arrayAdd(Collections.singletonMap("values", new Object()), 123);
        } catch (JSONException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
}
