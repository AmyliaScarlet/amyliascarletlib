package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;

public class OverriadeTest extends TestCase {

    public void test_override() throws Exception {
        JSON.parseObject("{\"id\":123}", B.class);
    }

    public static class A {

        protected long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            throw new UnsupportedOperationException();
        }

    }

    public static class B extends A {
        public void setId(String id) {
            this.id = Long.parseLong(id);
        }
    }
}
