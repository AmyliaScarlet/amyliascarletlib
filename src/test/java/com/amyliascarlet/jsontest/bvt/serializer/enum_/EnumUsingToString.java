package com.amyliascarlet.jsontest.bvt.serializer.enum_;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

/**
 * Created by wenshao on 17/03/2017.
 */
public class EnumUsingToString extends TestCase {
    public void test_toString() {
        Model model = new Model();
        model.gender = Gender.M;

        String text = JSON.toJSONString(model);
        assertEquals("{\"gender\":\"男\"}", text);
    }

    public static class Model {
        @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
        public Gender gender;
    }

    public static enum Gender {
        M("男"),
        W("女");
        private String msg;

        Gender(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return msg;
        }
    }
}
