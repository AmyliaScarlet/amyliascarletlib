package com.amyliascarlet.jsontest.bvt.parser.autoType;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.util.TypeUtils;
import junit.framework.TestCase;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentMap;

public class AutoTypeTest5 extends TestCase {
    ConcurrentMap<String,Class<?>> mappings;

    private static int count_x = 0;

    protected void setUp() throws Exception {
        Field field = TypeUtils.class.getDeclaredField("mappings");
        field.setAccessible(true);

        mappings = (ConcurrentMap<String,Class<?>>) field.get(null);
    }

    public void test_0() throws Exception {
        assertFalse(ParserConfig.getGlobalInstance().isAutoTypeSupport());
        JSON.parseObject("{\"value\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.autoType.AutoTypeTest5$V1\"}}", Model.class);

        int size = mappings.size();
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.parser.autoType.AutoTypeTest5$X1\"}}", Model.class);
        } catch (JSONException x) {
            error = x;
        }
        assertNotNull(error);
        assertEquals(0, count_x);
        assertEquals(size, mappings.size());
    }

    public static class Model {
        public V0 value;
    }

    public static class V0 {

    }

    public static class V1 extends V0 {

    }

    public static class X1 {
        static {
            count_x++;
        }
    }
}
