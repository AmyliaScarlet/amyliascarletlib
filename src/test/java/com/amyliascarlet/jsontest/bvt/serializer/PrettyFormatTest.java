package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class PrettyFormatTest extends TestCase {

    public void test_0() throws Exception {
        Assert.assertEquals(0, new JSONSerializer().getIndentCount());
        
        Assert.assertEquals("[\n\t{},\n\t{}\n]", JSON.toJSONString(new Object[] { new Object(), new Object() }, SerializerFeature.PrettyFormat));
    }
}
