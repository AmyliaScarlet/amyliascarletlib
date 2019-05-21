package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class JSONSerializerDeprecatedTest extends TestCase {

    public void test_() throws Exception {
        JSONSerializer ser = new JSONSerializer(new SerializeConfig());
        
        ser.setDateFormat(new ISO8601DateFormat());
        Assert.assertEquals(null, ser.getDateFormatPattern());
        
        ser.close();
    }
}
