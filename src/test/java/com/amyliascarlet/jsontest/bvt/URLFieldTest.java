package com.amyliascarlet.jsontest.bvt;

import java.net.URL;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class URLFieldTest extends TestCase {

    public void test_codec() throws Exception {
        User user = new User();
        user.setValue(new URL("http://code.amyliascarlet-tech.com"));

        SerializeConfig mapping = new SerializeConfig();
        mapping.setAsmEnable(false);
        String text = JSON.toJSONString(user, mapping, SerializerFeature.WriteMapNullValue);
        System.out.println(text);

        User user1 = JSON.parseObject(text, User.class);

        Assert.assertEquals(user1.getValue().toString(), user.getValue().toString());
    }

    public void test_codec_null() throws Exception {
        User user = new User();
        user.setValue(null);

        SerializeConfig mapping = new SerializeConfig();
        mapping.setAsmEnable(false);
        String text = JSON.toJSONString(user, mapping, SerializerFeature.WriteMapNullValue);

        User user1 = JSON.parseObject(text, User.class);

        Assert.assertEquals(user1.getValue(), user.getValue());
    }

    public static class User {

        private URL value;

        public URL getValue() {
            return value;
        }

        public void setValue(URL value) {
            this.value = value;
        }

    }
}
