package com.amyliascarlet.jsontest.bvt;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Method;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class TestExternal5 extends TestCase {
    ParserConfig confg = ParserConfig.global;
    protected void setUp() throws Exception {
        confg.addAccept("com.amyliascarlet.dubbo.demo");
    }

    public void test_0() throws Exception {
        ExtClassLoader classLoader = new ExtClassLoader();
        Class<?> clazz = classLoader.loadClass("com.amyliascarlet.dubbo.demo.MyEsbResultModel2");
        Method method = clazz.getMethod("setReturnValue", new Class[] { Serializable.class });

        Object obj = clazz.newInstance();
        method.invoke(obj, "AAAA");

        {
            String text = JSON.toJSONString(obj);
            System.out.println(text);
        }

        String text = JSON.toJSONString(obj, SerializerFeature.WriteClassName, SerializerFeature.WriteMapNullValue);
        System.out.println(text);
        Object object = JSON.parseObject(text, clazz, confg);
        assertEquals("a1", clazz.getName(), object.getClass().getName());

        Object object2 = JSON.parse(text, confg);
        assertEquals("a2 " + text, clazz.getName(), object2.getClass().getName());
    }

    public static class ExtClassLoader extends ClassLoader {

        public ExtClassLoader() throws IOException{
            super(Thread.currentThread().getContextClassLoader());

            {
                byte[] bytes;
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("external/MyEsbResultModel2.clazz");
                bytes = IOUtils.toByteArray(is);
                is.close();
                
                super.defineClass("com.amyliascarlet.dubbo.demo.MyEsbResultModel2", bytes, 0, bytes.length);
            }
        }
    }
}
