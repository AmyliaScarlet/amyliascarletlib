package com.amyliascarlet.jsontest.bvt.bug;

import org.junit.Assert;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;


public class Issue64 extends TestCase {
    public void test_for_issue() throws Exception {
        VO vo = new VO();
        vo.foo = "xxxxxx";
        
        String text = JSON.toJSONString(vo, SerializerFeature.BeanToArray);
        
        Assert.assertEquals("[\"xxxxxx\"]", text);
        
        VO vo2 = JSON.parseObject(text, VO.class, Feature.SupportArrayToBean);
        Assert.assertEquals(vo2.foo, vo.foo);
    }
    
    public static class VO {
        public String foo = "bar";
    }
}
