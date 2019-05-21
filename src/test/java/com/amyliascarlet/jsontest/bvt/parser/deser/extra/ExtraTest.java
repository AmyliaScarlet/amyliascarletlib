package com.amyliascarlet.jsontest.bvt.parser.deser.extra;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

/**
 * Created by wenshao on 30/03/2017.
 */
public class ExtraTest extends TestCase {
    public void test_0() throws Exception {
        JSON.parseObject("{\"ID\":123}", Model.class);
    }

    public static class Model {
        public int id;
    }
}
