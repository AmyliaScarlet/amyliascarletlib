package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.parser.DefaultJSONParser;

public class Bug_for_akvadrako extends TestCase {

    public void testNakedFields() throws Exception {
        Naked naked = new Naked();
        DefaultJSONParser parser = new DefaultJSONParser("{ \"field\": 3 }");
        parser.parseObject(naked);
    }

    public static class Naked {

        public int field;
    }
}
