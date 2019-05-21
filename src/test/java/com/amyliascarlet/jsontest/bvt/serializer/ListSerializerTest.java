package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ListSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSerializerTest extends TestCase {

    public void test_0_s() throws Exception {
        SerializeWriter out = new SerializeWriter();

        ListSerializer listSerializer = new ListSerializer();
        listSerializer.write(new JSONSerializer(out), Collections.EMPTY_LIST, null, null, 0);

        Assert.assertEquals("[]", out.toString());
    }

    public void test_2_s() throws Exception {
        SerializeWriter out = new SerializeWriter();

        ListSerializer listSerializer = new ListSerializer();
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(2);
        listSerializer.write(new JSONSerializer(out), list, null, null, 0);

        Assert.assertEquals("[1,2]", out.toString());
    }

    public void test_3_s() throws Exception {
        SerializeWriter out = new SerializeWriter();

        ListSerializer listSerializer = new ListSerializer();
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(2);
        list.add(3);
        listSerializer.write(new JSONSerializer(out), list, null, null, 0);

        Assert.assertEquals("[1,2,3]", out.toString());
    }

    public void test_4_s() throws Exception {
        SerializeWriter out = new SerializeWriter();

        ListSerializer listSerializer = new ListSerializer();
        List<Object> list = new ArrayList<Object>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(Collections.emptyMap());
        listSerializer.write(new JSONSerializer(out), list, null, null, 0);

        Assert.assertEquals("[1,2,3,{}]", out.toString());
    }

    public void test_5_s() throws Exception {
        SerializeWriter out = new SerializeWriter();

        ListSerializer listSerializer = new ListSerializer();
        List<Object> list = new ArrayList<Object>();
        list.add(1L);
        list.add(21474836480L);
        list.add(null);
        list.add(Collections.emptyMap());
        list.add(21474836480L);
        listSerializer.write(new JSONSerializer(out), list, null, null, 0);

        Assert.assertEquals("[1,21474836480,null,{},21474836480]", out.toString());
    }

    public void test_6_s() throws Exception {
        SerializeWriter out = new SerializeWriter(SerializerFeature.BrowserCompatible);

        ListSerializer listSerializer = new ListSerializer();
        List<Object> list = new ArrayList<Object>();
        list.add(1L);
        list.add(1453964515792017682L);
        listSerializer.write(new JSONSerializer(out), list, null, null, 0);

        Assert.assertEquals("[1,\"1453964515792017682\"]", out.toString());
    }

    public void test_7_s() throws Exception {
        SerializeWriter out = new SerializeWriter(
                SerializerFeature.BrowserCompatible, SerializerFeature.WriteClassName
        );

        ListSerializer listSerializer = new ListSerializer();
        List<Object> list = new ArrayList<Object>();
        list.add(1L);
        list.add(1453964515792017682L);
        listSerializer.write(new JSONSerializer(out), list, null, null, 0);

        Assert.assertEquals("[1L,1453964515792017682L]", out.toString());
    }

    public void test_8_s() throws Exception {
        SerializeWriter out = new SerializeWriter(SerializerFeature.WriteClassName);

        ListSerializer listSerializer = new ListSerializer();
        List<Object> list = new ArrayList<Object>();
        list.add(1L);
        list.add(1453964515792017682L);
        listSerializer.write(new JSONSerializer(out), list, null, null, 0);

        Assert.assertEquals("[1L,1453964515792017682L]", out.toString());
    }
}
