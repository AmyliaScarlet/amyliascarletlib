package com.amyliascarlet.jsontest.bvt.serializer.features;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

/**
 * Created by wenshao on 01/04/2017.
 */
public class NotWriteDefaultValueFieldTest extends TestCase {
    public void test_not_write_default() throws Exception {
        assertEquals("{}", JSON.toJSONString(new Model(0)));
        assertEquals("{\"id\":1}", JSON.toJSONString(new Model(1)));
    }

    public static class Model {

        @JSONField(serialzeFeatures = SerializerFeature.NotWriteDefaultValue)
        public int id;

        public Model(int id) {
            this.id = id;
        }
    }
}
