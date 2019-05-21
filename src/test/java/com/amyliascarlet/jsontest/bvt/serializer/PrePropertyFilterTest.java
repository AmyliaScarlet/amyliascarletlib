package com.amyliascarlet.jsontest.bvt.serializer;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.PropertyPreFilter;

public class PrePropertyFilterTest extends TestCase {

    public void test_0() throws Exception {
        class VO {
            public int getId() { throw new RuntimeException(); }
        }

        PropertyPreFilter filter = new PropertyPreFilter () {
            public boolean apply(JSONSerializer serializer, Object source, String name) {
                return false;
            }
        };

        VO vo = new VO();

        String text = JSON.toJSONString(vo, filter);
        Assert.assertEquals("{}", text);
    }

}
