package com.amyliascarlet.jsontest.bvt.serializer;

import java.text.DecimalFormat;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.DoubleSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;

public class DoubleTest_custom extends TestCase {

    public void test_0() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.put(Double.class, new DoubleSerializer(new DecimalFormat("###.##")));
        Assert.assertEquals("1.12", JSON.toJSONString(1.123456789D, config));
    }
    
    public void test_1() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.put(Double.class, new DoubleSerializer("###.###"));
        Assert.assertEquals("1.123", JSON.toJSONString(1.123456789D, config));
    }
}
