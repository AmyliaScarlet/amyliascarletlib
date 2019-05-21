package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

/**
 * Created by wenshao on 15/01/2017.
 */
public class Issue995 extends TestCase {
    public void test_for_issue() throws Exception {
        Person person = new Person();

        JSONPath.set(person, "$.nose.name", "xxx");
    }

    public static class Person {
        public Nose nose;
    }

    public static class Nose {
        public String name;
    }
}
