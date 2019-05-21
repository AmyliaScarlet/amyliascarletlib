package com.amyliascarlet.jsontest.bvt.writeAsArray;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.jsontest.test.benchmark.decode.EishayDecodeBytes;

import data.media.MediaContent;

public class WriteAsArray_Eishay extends TestCase {
    public void test_0 () throws Exception {
        MediaContent content = EishayDecodeBytes.instance.getContent();
        
        String text = JSON.toJSONString(content, SerializerFeature.BeanToArray);
        System.out.println(text.getBytes().length);
        JSON.parseObject(text, MediaContent.class, Feature.SupportArrayToBean);
    }
    
    public static class VO {
        private short id;
        private String name;

        public short getId() {
            return id;
        }

        public void setId(short id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
