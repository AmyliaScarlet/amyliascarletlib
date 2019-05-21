package com.amyliascarlet.jsontest.bvt.serializer;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class InetSocketAddressTest extends TestCase {

    public void test_timezone() throws Exception {
        InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 80);
        
        String text = JSON.toJSONString(address);

        InetSocketAddress address2 = JSON.parseObject(text,  InetSocketAddress.class);
        Assert.assertEquals(address, address2);
    }
}
