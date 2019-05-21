package com.amyliascarlet.jsontest.bvt.parser.deser;

import java.util.List;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.ParserConfig;

public class DefaultObjectDeserializerTest12 extends TestCase {

    public void test_list() throws Exception {
        A a = new A();
        DefaultJSONParser parser = new DefaultJSONParser("{\"values\":[]}", ParserConfig.getGlobalInstance());
        parser.parseObject(a);
        parser.close();
    }

    public static class A {

        private List values;

        public List getValues() {
            return values;
        }

        public void setValues(List values) {
            this.values = values;
        }

    }
}
