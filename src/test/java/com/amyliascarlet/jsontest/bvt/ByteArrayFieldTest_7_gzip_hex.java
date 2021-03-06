package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;
import org.junit.Assert;

public class ByteArrayFieldTest_7_gzip_hex extends TestCase {

    public void test_0() throws Exception {
        Model model = new Model();

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 1000; ++i) {
            buf.append("0123456890");
            buf.append("ABCDEFGHIJ");
        }

        model.value = buf.toString().getBytes();

        String json = JSON.toJSONString(model);

        assertEquals("{\"value\":\"H4sIAAAAAAAAAO3IsRGAIBAAsJVeUE5LBBXcfyC3sErKxJLyupX9iHq2ft3PmG8455xzzjnnnHPOOeecc84555xzzjnnnHPOOeecc84555xzzjnnnHPOOeecc84555z7/T6powiAIE4AAA==\"}", json);

        Model model1 = JSON.parseObject(json, Model.class);
        Assert.assertArrayEquals(model.value, model1.value);
    }

    private static class Model {

        @JSONField(format = "gzip,base64")
        public byte[] value;


    }
}
