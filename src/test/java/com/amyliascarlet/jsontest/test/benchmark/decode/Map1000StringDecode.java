package com.amyliascarlet.jsontest.test.benchmark.decode;

import java.util.HashMap;
import java.util.Map;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

public class Map1000StringDecode extends BenchmarkCase {

    private String text;

    public Map1000StringDecode(){
        super("Map100StringDecode");

        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 1000; ++i) {
            map.put("f" + i, Integer.toString(i));
        }

        this.text = JSON.toJSONString(map) + ' ';
    }

    @Override
    public void execute(Codec codec) throws Exception {
        codec.decodeObject(text);
    }
}
