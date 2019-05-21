package com.amyliascarlet.jsontest.test.benchmark.decode;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.benchmark.entity.Entity100String;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class Entity100StringDecode extends BenchmarkCase {

    private String text;

    public Entity100StringDecode(){
        super("Entity100StringDecode");

        this.text = JSON.toJSONString(new Entity100String());
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.decodeObject(text, Entity100String.class);
    }
}
