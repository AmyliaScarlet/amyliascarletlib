package com.amyliascarlet.jsontest.bvt.bug;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class Bug_for_lenolix_11 extends TestCase {
    protected void setUp() throws Exception {
        JSON.defaultTimeZone = TimeZone.getTimeZone("Asia/Shanghai");
        JSON.defaultLocale = Locale.CHINA;

        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.bug.Bug_for_lenolix_11.");
    }
    
    public void test_for_objectKey() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy", JSON.defaultLocale);
        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);

        String simpleDateFormatJson = JSON.toJSONString(simpleDateFormat, SerializerFeature.WriteClassName,
                                                        SerializerFeature.WriteMapNullValue);

        System.out.println(simpleDateFormatJson);

        java.text.SimpleDateFormat format = (java.text.SimpleDateFormat) JSON.parse(simpleDateFormatJson);
        Assert.assertEquals("MM-dd-yyyy", format.toPattern());

    }

    public static class User {

        private int     id;
        private Boolean isBoy;
        private String  name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Boolean getIsBoy() {
            return isBoy;
        }

        public void setIsBoy(Boolean isBoy) {
            this.isBoy = isBoy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
