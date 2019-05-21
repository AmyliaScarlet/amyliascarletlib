package com.amyliascarlet.jsontest.test.benchmark.decode;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.benchmark.entity.Entity100Int;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class Entity100IntDecode extends BenchmarkCase {

    private String text;

    public Entity100IntDecode(){
        super("StringArray1000Decode");

        this.text = JSON.toJSONString(new Entity100Int());
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.decodeObject(text, Entity100Int.class);
    }
}
