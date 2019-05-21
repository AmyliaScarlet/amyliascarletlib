package com.amyliascarlet.jsontest.bvt.annotation;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author by laugh on 16/9/28 12:08.
 */
public class SerializeUsingWhenString extends TestCase {
    public void test_annotation() throws Exception {
        Model model = new Model();
        model.value = "100";
        Assert.assertEquals("{\"value\":\"100元\"}", JSON.toJSONString(model));

        ModelWithOutJsonField modelWithOutJsonField = new ModelWithOutJsonField();
        modelWithOutJsonField.value = "100";
        Assert.assertEquals("{\"value\":\"100\"}", JSON.toJSONString(modelWithOutJsonField));
    }

    public static class Model {

        @JSONField(serializeUsing = ModelValueSerializer.class)
        public String value;
    }

    public static class ModelWithOutJsonField {

        public String value;
    }

    public static class ModelValueSerializer implements ObjectSerializer {

        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                          int features) throws IOException {
            String value = (String) object;
            String text = value + "元";
            serializer.write(text);
        }
    }
}
