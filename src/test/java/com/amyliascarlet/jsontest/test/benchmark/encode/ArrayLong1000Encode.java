package com.amyliascarlet.jsontest.test.benchmark.encode;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class ArrayLong1000Encode extends BenchmarkCase {

    private Object object;

    public ArrayLong1000Encode(){
        super("ArrayLong1000Encode");

        long[] array = new long[1000];
        for (int i = 0; i < array.length; ++i) {
            array[i] = i;
        }
        this.object = array;
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.encode(object);
    }
}
