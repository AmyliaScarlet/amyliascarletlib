package com.amyliascarlet.jsontest.bvt.serializer.filters;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.AfterFilter;

public class AfterFilterTest2 extends TestCase {
    public void test_afterFilter() throws Exception {
        AfterFilter filter = new AfterFilter() {
            
            @Override
            public void writeAfter(Object object) {
                this.writeKeyValue("id", 123);
            }
        };
        Assert.assertEquals("{\"id\":123}",JSON.toJSONString( new VO(), filter));
    }
    
    public void test_afterFilter2() throws Exception {
        AfterFilter filter = new AfterFilter() {
            
            @Override
            public void writeAfter(Object object) {
                this.writeKeyValue("id", 123);
                this.writeKeyValue("name", "wenshao");
            }
        };
        Assert.assertEquals("{\"id\":123,\"name\":\"wenshao\"}", JSON.toJSONString(new VO(), filter));
    }
    
    public static class VO {
        
    }
}
