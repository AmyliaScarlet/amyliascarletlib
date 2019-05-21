package com.amyliascarlet.jsontest.test.performance.case1;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

public class GenerateTest extends TestCase {

    public void testGenInt() throws Exception {
        JSONObject json = new JSONObject(true);
        for (int i = 0; i < 100; ++i) {
            json.put("f" + i, i);
        }
        String text = JSON.toJSONString(json, false);
        System.out.println(text);
        FileUtils.writeStringToFile(new File("d:/int_array_1000.jsontest"), text);
    }
}
