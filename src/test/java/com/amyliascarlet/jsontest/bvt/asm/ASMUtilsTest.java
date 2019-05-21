package com.amyliascarlet.jsontest.bvt.asm;

import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.junit.Assert;

import com.amyliascarlet.lib.json.parser.ParseContext;
import com.amyliascarlet.lib.json.util.ASMUtils;

public class ASMUtilsTest extends TestCase {

    public void test_isAnroid() throws Exception {
        Assert.assertTrue(ASMUtils.isAndroid("Dalvik"));
    }

    public void test_getDescs() throws Exception {
        Assert.assertEquals("Lcom/amyliascarlet/json/parser/ParseContext;", ASMUtils.desc(ParseContext.class));
    }

    public void test_getType_null() throws Exception {
        Assert.assertNull(ASMUtils.getMethodType(ParseContext.class, "XX"));
    }
    
    public static Type getMethodType(Class<?> clazz, String methodName) {
        try {
            Method method = clazz.getMethod(methodName);

            return method.getGenericReturnType();
        } catch (Exception ex) {
            return null;
        }
    }
}
