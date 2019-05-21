package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;

public class GenericTypeTest2 extends TestCase {
    
    public void test_gerneric() throws Exception {
        MyResultResult result = new MyResultResult();
        JSON.toJSONString(result);
    }
    
    public static class MyResultResult extends BaseResult<String> {
    }
    
    public static class BaseResult<T>  {
        private T data;
        public T getData() {
            return data;
        }
    }
}
