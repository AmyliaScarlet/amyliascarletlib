package com.amyliascarlet.jsontest.bvt;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.util.TypeUtils;

public class MaterializedInterfaceTest2 extends TestCase {
    
    public void test_parse() throws Exception {
        String text = "{\"id\":123, \"name\":\"chris\"}";
        JSONObject object = JSON.parseObject(text);
        
        Bean bean = TypeUtils.cast(object, Bean.class, null);
        
        Assert.assertEquals(123, bean.getId());
        Assert.assertEquals("chris", bean.getName());
        
        String text2 = JSON.toJSONString(bean);
        System.out.println(text2);
    }

    public static interface Bean {
        int getId();

        void setId(int value);

        String getName();

        void setName(String value);
    }
}
