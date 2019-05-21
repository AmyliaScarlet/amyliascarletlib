package com.amyliascarlet.jsontest.test.benchmark.decode;

import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

import data.media.MediaContent;

public class EishayDecode extends BenchmarkCase {

    private String text;

    public EishayDecode(){
        super("EishayDecode");

        // JavaBeanMapping.getGlobalInstance().putDeserializer(Image.class, new ImageDeserializer());
        // JavaBeanMapping.getGlobalInstance().putDeserializer(Media.class, new MediaDeserializer());
    }

    public void init(Codec codec) throws Exception {
        this.text = codec.encode(EishayDecodeBytes.instance.getContent());
        System.out.println(text);
    }

    @Override
    public void execute(Codec codec) throws Exception {
        MediaContent content = codec.decodeObject(text, MediaContent.class);
        if (content == null) {
            throw new Exception();
        }
    }

}
