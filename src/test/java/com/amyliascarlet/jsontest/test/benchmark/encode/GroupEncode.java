package com.amyliascarlet.jsontest.test.benchmark.encode;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;
import com.amyliascarlet.jsontest.test.entity.Group;

public class GroupEncode extends BenchmarkCase {

    private Object object;

    public GroupEncode(){
        super("GroupEncode");

        try {
            String resource = "json/group.json";
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            String text = IOUtils.toString(is);
            is.close();

            object = JSON.parseObject(text, Group.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void execute(Codec codec) throws Exception {
        for (int i = 0; i < 10; ++i) {
            codec.encode(object);
        }
    }
}
