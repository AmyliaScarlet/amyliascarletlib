package com.amyliascarlet.jsontest.test.benchmark.decode;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class EishayTreeDecode extends BenchmarkCase {

    private final String text;

    public EishayTreeDecode(){
        super("EishayDecode-tree");

        this.text = EishayDecodeBytes.instance.getText();
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.decode(text);
    }

}
