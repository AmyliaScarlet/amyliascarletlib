package com.amyliascarlet.jsontest.bvt.issue_1600;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.PascalNameFilter;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

import java.util.List;

public class Issue1635 extends TestCase {
    public static class Foo {
        public String name;
        public Integer BarCount;
        public Boolean flag;
        public List list;

        public Foo(String name, Integer barCount) {
            this.name = name;
            BarCount = barCount;
        }
    }

    public void test_issue() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.setAsmEnable(false);
        Foo foo = new Foo(null, null);
        String json = JSON.toJSONString(foo
                , config, new PascalNameFilter()
                , SerializerFeature.WriteNullBooleanAsFalse
                , SerializerFeature.WriteNullNumberAsZero
                , SerializerFeature.WriteNullStringAsEmpty
                , SerializerFeature.WriteNullListAsEmpty
        );
        assertEquals("{\"BarCount\":0,\"Flag\":false,\"List\":[],\"Name\":\"\"}", json);
    }

    public void test_issue_1() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.setAsmEnable(false);
        Foo foo = new Foo(null, null);
        String json = JSON.toJSONString(foo
                , config, new PascalNameFilter()
                , SerializerFeature.WriteNullBooleanAsFalse
                , SerializerFeature.WriteNullNumberAsZero
                , SerializerFeature.WriteNullStringAsEmpty
                , SerializerFeature.WriteNullListAsEmpty
                , SerializerFeature.BeanToArray
        );
        assertEquals("[0,false,[],\"\"]", json);
    }
}
