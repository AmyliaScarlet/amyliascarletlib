package com.amyliascarlet.jsontest.test.benchmark.encode;

import java.util.HashMap;
import java.util.Map;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class Map1000Encode extends BenchmarkCase {

    private Object object;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map1000Encode(){
        super("Map1000Encode");

        Map map = new HashMap();
        for (int i = 0; i < 1000; ++i) {
            map.put(Integer.toString(i), i);
        }
        this.object = map;
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.encode(object);
    }
}
