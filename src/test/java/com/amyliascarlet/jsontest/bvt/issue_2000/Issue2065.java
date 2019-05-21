package com.amyliascarlet.jsontest.bvt.issue_2000;

import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;

public class Issue2065 extends TestCase {
    public void test_for_issue() throws Exception {
        // JSON.parseObject("{\"code\":1}", EasyThreadModel.class);
    }

    public static class Model {
        @JSONField(name = "code")
        private EnumClass code;

        public Model() {}

        public EnumClass getCode() {
            return code;
        }

        public void setCode(EnumClass code) {
            this.code = code;
        }
    }

    public static enum EnumClass {
        A(1);

        @JSONField
        private int code;

        EnumClass(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
