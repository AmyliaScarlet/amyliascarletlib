package com.amyliascarlet.jsontest.bvt.writeClassName;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

public class StrictAutoTypeTest_0 extends TestCase {
    private ParserConfig config = new ParserConfig();

    public void test_0() throws Exception {
        JSON.parseObject("{\"@type\":\"com.amyliascarlet.json.JSONObject\"}", Object.class, config);
        JSON.parseObject("{\"@type\":\"com.amyliascarlet.json.JSONObject\"}", Object.class, config, Feature.SupportAutoType);
    }

    public void test_1() throws Exception {
        JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.StrictAutoTypeTest_0$VO\"}", Object.class, config, Feature.SupportAutoType);
    }

    public void test_2() throws Exception {
        {
            Exception error = null;
            try {
                JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.StrictAutoTypeTest_0$V1\"}", Object.class, config);
            } catch (JSONException ex) {
                error = ex;
            }
            assertNotNull(error);
        }
        {
            Exception error = null;
            try {
                JSON.parseObject("{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.StrictAutoTypeTest_0$V1\"}", Object.class, config);
            } catch (JSONException ex) {
                error = ex;
            }
            assertNotNull(error);
        }
    }

    public void test_3() throws Exception {
        int features = JSON.DEFAULT_PARSER_FEATURE | Feature.SupportAutoType.mask;
        JSON.parse("{\"val\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.StrictAutoTypeTest_0$V3\"}}", config, features);
    }

    public static class VO {

    }
    public static class V1 {

    }
    public static class V2 {

    }
    public static class V3 {

    }
}
