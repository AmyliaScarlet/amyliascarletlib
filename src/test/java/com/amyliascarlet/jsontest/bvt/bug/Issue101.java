package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class Issue101 extends TestCase {

    public void test_for_issure() throws Exception {
        VO vo = new VO();
        vo.a = new Object();
        vo.b = vo.a;
        vo.c = vo.a;
        
        String text = JSON.toJSONString(vo);
        Assert.assertEquals("{\"a\":{},\"b\":{},\"c\":{}}", text);
    }

    @JSONType(serialzeFeatures=SerializerFeature.DisableCircularReferenceDetect)
    public static class VO {

        private Object a;
        private Object b;
        private Object c;

        public Object getA() {
            return a;
        }

        public void setA(Object a) {
            this.a = a;
        }

        public Object getB() {
            return b;
        }

        public void setB(Object b) {
            this.b = b;
        }

        public Object getC() {
            return c;
        }

        public void setC(Object c) {
            this.c = c;
        }

    }
}
