package com.amyliascarlet.jsontest.test.benchmark.encode;

import java.util.Arrays;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class ListBoolean1000Encode extends BenchmarkCase {

    private Object object;

    public ListBoolean1000Encode(){
        super("BooleanArray1000Encode");

        boolean[] array = new boolean[1000];
        for (int i = 0; i < array.length; ++i) {
            array[i] = (i % 2 == 0);
        }
        this.object = Arrays.asList(array);
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.encode(object);
    }
}
