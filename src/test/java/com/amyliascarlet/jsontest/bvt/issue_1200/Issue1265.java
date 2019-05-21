package com.amyliascarlet.jsontest.bvt.issue_1200;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.TypeReference;
import junit.framework.TestCase;

/**
 * Created by wenshao on 22/07/2017.
 */
public class Issue1265 extends TestCase {
    public void test_0() throws Exception {
        Object t = JSON.parseObject("{\"value\":{\"id\":123}}", new TypeReference<Response>(){}).value;
        assertEquals(123, ((JSONObject) t).getIntValue("id"));

        T1 t1 = JSON.parseObject("{\"value\":{\"id\":123}}", new TypeReference<Response<T1>>(){}).value;
        assertEquals(123, t1.id);

        T2 t2 = JSON.parseObject("{\"value\":{\"id\":123}}", new TypeReference<Response<T2>>(){}).value;
        assertEquals(123, t2.id);

    }

    public static class Response<T> {
        public T value;
    }

    public static class T1 {
        public int id;
    }

    public static class T2 {
        public int id;
    }
}
