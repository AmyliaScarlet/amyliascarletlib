package com.amyliascarlet.jsontest.test.benchmark.encode;

import java.util.Collections;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class ArrayObjectEmptyMap1000Encode extends BenchmarkCase {

    private Object object;

    public ArrayObjectEmptyMap1000Encode(){
        super("ArrayObjectEmptyMap1000Encode");

        Object[] array = new Object[1000];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Collections.emptyMap();
        }
        this.object = array;
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.encode(object);
    }
}
