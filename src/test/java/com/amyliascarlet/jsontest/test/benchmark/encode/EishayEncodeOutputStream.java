package com.amyliascarlet.jsontest.test.benchmark.encode;

import java.io.IOException;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class EishayEncodeOutputStream extends BenchmarkCase {

    private DummyOutputStream out = new DummyOutputStream();

    public EishayEncodeOutputStream(){
        super("EishayEncode-outputstream");

    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.encode(out, EishayEncode.mediaContent);
    }

    public static class DummyOutputStream extends java.io.OutputStream {

        @Override
        public void write(int b) throws IOException {

        }

    }

}
