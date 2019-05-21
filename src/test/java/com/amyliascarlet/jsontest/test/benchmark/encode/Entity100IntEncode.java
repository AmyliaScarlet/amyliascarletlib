package com.amyliascarlet.jsontest.test.benchmark.encode;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.benchmark.entity.Entity100Int;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class Entity100IntEncode extends BenchmarkCase {

    private Object object;

    public Entity100IntEncode(){
        super("Entity100IntEncode");

        Entity100Int entity = new Entity100Int();

        this.object = entity;
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.encode(object);
    }
}
