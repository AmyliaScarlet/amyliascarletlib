package com.amyliascarlet.jsontest.bvt;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class TestTimeUnit extends TestCase {
    public void test_0 () throws Exception {
        String text = JSON.toJSONString(TimeUnit.DAYS);
        Assert.assertEquals(TimeUnit.DAYS, JSON.parseObject(text, TimeUnit.class));
    }
}
