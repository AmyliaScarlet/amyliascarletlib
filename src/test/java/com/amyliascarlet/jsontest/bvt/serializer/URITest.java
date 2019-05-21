package com.amyliascarlet.jsontest.bvt.serializer;

import java.net.URI;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class URITest extends TestCase {

    public void test_file() throws Exception {
        URI uri = URI.create("http://www.amyliascarlet.com/");

        String text = JSON.toJSONString(uri);

        Assert.assertEquals(JSON.toJSONString(uri.toString()), text);

        URI uri2 = JSON.parseObject(text, URI.class);
        Assert.assertEquals(uri.toString(), uri2.toString());
    }
}
