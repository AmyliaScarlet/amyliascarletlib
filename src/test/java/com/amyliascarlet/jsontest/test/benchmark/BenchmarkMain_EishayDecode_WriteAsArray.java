package com.amyliascarlet.jsontest.test.benchmark;

import java.lang.management.ManagementFactory;
import java.util.List;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.jsontest.test.TestUtils;
import com.amyliascarlet.jsontest.test.benchmark.decode.EishayDecodeBytes;

import data.media.MediaContent;

public class BenchmarkMain_EishayDecode_WriteAsArray {

    public static void main(String[] args) throws Exception {
//        SerializeConfig config = SerializeConfig.getGlobalInstance();
//        config.put(MediaContent.class, new MediaContentSerializer());
//        config.put(Media.class, new MediaSerializer());
//        config.put(Image.class, new ImageSerializer());

//        ParserConfig.getGlobalInstance().putDeserializer(MediaContent.class, new MediaContentDeserializer());
        
        System.out.println(System.getProperty("java.vm.name") + " " + System.getProperty("java.runtime.version"));
        List<String> arguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println(arguments);

        String text = JSON.toJSONString(EishayDecodeBytes.instance.getContent(), SerializerFeature.BeanToArray);
        System.out.println(text);
        
        for (int i = 0; i < 10; ++i) {
            perf(text);
        }
    }

    static long perf(String text) {
        long startYGC = TestUtils.getYoungGC();
        long startYGCTime = TestUtils.getYoungGCTime();
        long startFGC = TestUtils.getFullGC();

        long startMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; ++i) {
            decode(text);
        }
        long millis = System.currentTimeMillis() - startMillis;

        long ygc = TestUtils.getYoungGC() - startYGC;
        long ygct = TestUtils.getYoungGCTime() - startYGCTime;
        long fgc = TestUtils.getFullGC() - startFGC;

        System.out.println("decode\t" + millis + ", ygc " + ygc + ", ygct " + ygct + ", fgc " + fgc);
        return millis;
    }

    static void decode(String text) {
        MediaContent content = JSON.parseObject(text, MediaContent.class, Feature.SupportArrayToBean);
        
//        JSON.parseObject(text);
    }
}
