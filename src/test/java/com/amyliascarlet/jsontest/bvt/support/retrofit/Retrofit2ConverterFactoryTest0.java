package com.amyliascarlet.jsontest.bvt.support.retrofit;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.lib.json.support.config.FastJsonConfig;
import com.amyliascarlet.lib.json.support.retrofit.Retrofit2ConverterFactory;
import junit.framework.TestCase;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import org.junit.Assert;

import java.nio.charset.Charset;

public class Retrofit2ConverterFactoryTest0 extends TestCase {
    public void test_for_coverage() throws Exception {
        Retrofit2ConverterFactory f = new Retrofit2ConverterFactory();
        f.getParserConfig();
        f.getParserFeatures();
        f.getParserFeatureValues();
        f.getSerializeConfig();
        f.getSerializerFeatures();
        f.setParserConfig(ParserConfig.getGlobalInstance());
        f.setParserFeatures(new Feature[0]);
        f.setParserFeatureValues(0);
        f.setSerializeConfig(SerializeConfig.globalInstance);
        f.setSerializerFeatures(new SerializerFeature[0]);
        f.getFastJsonConfig();
        f.setFastJsonConfig(new FastJsonConfig());
        f.requestBodyConverter(Model.class, null, null, null);
        f.responseBodyConverter(Model.class, null, null);

        final Model model = new Model().setId(1).setName("test");
        final String json = JSON.toJSONString(model);
        final Buffer buffer = new Buffer().writeString(json, Charset.defaultCharset());
        final Headers headers = Headers.of("Content-Type", "application/jsontest; charset=UTF-8");
        final ResponseBody body = new RealResponseBody(headers, buffer);

        RequestBody requestBody = Retrofit2ConverterFactory.create()
                .requestBodyConverter(Model.class, null, null, null)
                .convert(model);

        Assert.assertNotEquals(requestBody.contentLength(), 0);

        Model mode2 = (Model) Retrofit2ConverterFactory.create()
                .responseBodyConverter(Model.class, null, null)
                .convert(body);

        Assert.assertEquals(JSON.toJSONString(mode2), json);
    }

    public static class Model {

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public Model setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Model setName(String name) {
            this.name = name;
            return this;
        }
    }
}
