package com.amyliascarlet.jsontest.bvt.parser.deser;

import com.amyliascarlet.lib.json.JSON;

import org.junit.Assert;
import junit.framework.TestCase;


public class FieldDeserializerTest8 extends TestCase {
    public void test_0 () throws Exception {
        Assert.assertEquals("33", JSON.parseObject("{\"id\":\"33\"\t}", VO.class).id);
        Assert.assertEquals("33", JSON.parseObject("{\"id\":\"33\"\t}\n\t", VO.class).id);
        Assert.assertEquals("33", JSON.parseObject("{\"id\":\"33\" }", V1.class).id);
        Assert.assertEquals("33", JSON.parseObject("{\"id\":\"33\" }\n\t", V1.class).id);
        Assert.assertEquals("33", JSON.parseObject("{\"id\":\"33\"\n}", V1.class).id);
    }
    
    public static class VO {
        public String id;
    }
    
    private static class V1 {
        public String id;
    }
}
