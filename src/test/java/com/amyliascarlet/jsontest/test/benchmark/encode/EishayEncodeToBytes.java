package com.amyliascarlet.jsontest.test.benchmark.encode;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class EishayEncodeToBytes extends BenchmarkCase {

    public EishayEncodeToBytes(){
        super("EishayEncodeToBytes");

    }

    @Override
    public void execute(Codec codec) throws Exception {
        byte[] text = codec.encodeToBytes(EishayEncode.mediaContent);
        if (text == null) {
            throw new Exception();
        }
    }


}
