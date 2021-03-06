package com.amyliascarlet.jsontest.bvt.builder;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONPOJOBuilder;
import com.amyliascarlet.lib.json.annotation.JSONType;

import junit.framework.TestCase;

public class BuilderTest3 extends TestCase {
    
    public void test_create() throws Exception {
        VO vo = JSON.parseObject("{\"id\":12304,\"name\":\"ljw\"}", VO.class);
        
        Assert.assertEquals(12304, vo.getId());
        Assert.assertEquals("ljw", vo.getName());
    }

    @JSONType(builder=VOBuilder.class)
    public static class VO {
        private int id;
        private String name;
        
        public int getId() {
            return id;
        }
        
        public String getName() {
            return name;
        }
    }

    @JSONPOJOBuilder(withPrefix="kk", buildMethod="mmm")
    public static class VOBuilder {

        private VO vo = new VO();

        public VO mmm() {
            return vo;
        }
        
        public VOBuilder kkId(int id) {
            vo.id = id;
            return this;
        }
        
        public VOBuilder kkName(String name) {
            vo.name = name;
            return this;
        }
    }
}
