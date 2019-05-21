package com.amyliascarlet.jsontest.bvt.parser.deser;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class FieldSerializerTest extends TestCase {

    public void test_writeNull() throws Exception {
        String text = JSON.toJSONString(new Entity());
        Assert.assertEquals("{\"v\":null}", text);
    }

    private static class Entity {

        private transient int id;
        @JSONField(name = "v", serialzeFeatures = { SerializerFeature.WriteMapNullValue })
        private String        value;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}
