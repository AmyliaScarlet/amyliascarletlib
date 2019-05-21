package com.amyliascarlet.jsontest.bvt;

import java.util.Random;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class LongFieldTest_4 extends TestCase {

    public void test_min() throws Exception {
        Random random = new Random();
        Model[] array = new Model[2048];
        for (int i = 0; i < array.length; ++i) {
            array[i] = new Model();
            array[i].value = random.nextLong();
        }

        String text = JSON.toJSONString(array);

        Model[] array2 = JSON.parseObject(text, Model[].class);

        Assert.assertEquals(array.length, array2.length);
        for (int i = 0; i < array.length; ++i) {
            Assert.assertEquals(array[i].value, array2[i].value);
        }
    }

    @JSONType(serialzeFeatures = SerializerFeature.BeanToArray, parseFeatures = Feature.SupportArrayToBean)
    public static class Model {

        public long value;

    }
}
