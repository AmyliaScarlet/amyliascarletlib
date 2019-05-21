package com.amyliascarlet.jsontest.test.tmall;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.util.IOUtils;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileReader;

/**
 * Created by wenshao on 17/03/2017.
 */
public class TmallTest extends TestCase {
    @SuppressWarnings("deprecation")
    public void test_for_tmall() throws Exception {
        File file = new File("/Users/wenshao/Downloads/tmall_perf/searchjson.jsontest");
        String text = IOUtils.readAll(new FileReader(file));

        for (int i = 0; i < 10; ++i) {
            long start = System.currentTimeMillis();
            perf(text);
            long millis = System.currentTimeMillis() - start;
            System.out.println("millis : " + millis);
        }
    }

    private void perf(String text) {
        for (int i = 0; i < 1000; ++i) {
            JSON.parseObject(text, EngineResult.class, Feature.DisableFieldSmartMatch);
        }
    }
}
