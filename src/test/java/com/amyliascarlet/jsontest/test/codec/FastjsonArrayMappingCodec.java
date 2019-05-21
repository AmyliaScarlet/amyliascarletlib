package com.amyliascarlet.jsontest.test.codec;

import java.io.OutputStream;
import java.util.Collection;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class FastjsonArrayMappingCodec implements Codec {

    private ParserConfig    config = ParserConfig.getGlobalInstance();

    public FastjsonArrayMappingCodec(){
        System.out.println("json-" + JSON.VERSION);
    }

    public String getName() {
        return "json-BeanToArray";
    }

    public <T> T decodeObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz, Feature.DisableCircularReferenceDetect, Feature.SupportArrayToBean);
    }

    public <T> Collection<T> decodeArray(String text, Class<T> clazz) throws Exception {
        DefaultJSONParser parser = new DefaultJSONParser(text, config);
        parser.config(Feature.DisableCircularReferenceDetect, true);
        return parser.parseArray(clazz);
    }

    public final Object decodeObject(String text) {
        return JSON.parseObject(text, Feature.DisableCircularReferenceDetect, Feature.SupportArrayToBean);
    }

    public final Object decode(String text) {
        return JSON.parseObject(text, Feature.DisableCircularReferenceDetect, Feature.SupportArrayToBean);
    }

    // private JavaBeanSerializer serializer = new JavaBeanSerializer(Long_100_Entity.class);

    public String encode(Object object) throws Exception {
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.BeanToArray);
    }

    @SuppressWarnings("unchecked")
    public <T> T decodeObject(byte[] input, Class<T> clazz) throws Exception {
        return (T) JSON.parseObject(input, clazz, Feature.DisableCircularReferenceDetect, Feature.SupportArrayToBean);
    }

    @Override
    public byte[] encodeToBytes(Object object) throws Exception {
        return JSON.toJSONBytes(object, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.BeanToArray);
    }

    @Override
    public void encode(OutputStream out, Object object) throws Exception {
       JSON.writeJSONString(out, object, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.BeanToArray);
    }

}
