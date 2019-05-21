package com.amyliascarlet.jsontest.bvt.parser;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;
import com.amyliascarlet.jsontest.bvtVO.ae.*;
import junit.framework.TestCase;

import java.lang.reflect.Type;

/**
 * Created by wenshao on 08/05/2017.
 */
public class AETest extends TestCase {
    static String jsonData = "{\n" +
            "    \"areaList\":[\n" +
            "        {\n" +
            "            \"type\":\"floor\",\n" +
            "            \"name\":\"I'm floor\",\n" +
            "            \"children\":[{\n" +
            "                \"type\":\"item\",\n" +
            "            \"name\":\"I'm item 0\"\n" +
            "            },\n" +
            "        {\n" +
            "              \"type\":\"item\",\n" +
            "            \"name\":\"I'm item 1\"\n" +
            "        }\n" +
            "\n" +
            "            ]\n" +
            "        },{\n" +
            "            \"type\":\"item\",\n" +
            "            \"name\":\"I'm item 2\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public void test_for_ae() throws Exception {
        ParserConfig.getGlobalInstance().putDeserializer(Area.class, new ObjectDeserializer() {
            public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
                JSONObject jsonObject = (JSONObject) parser.parse();
                String areaType;

                if (jsonObject.get("type") instanceof String) {
                    areaType = (String) jsonObject.get("type");
                } else {
                    return null;
                }
                if (Area.TYPE_FLOOR.equals(areaType)) {
                     return (T) JSON.toJavaObject(jsonObject, Floor.class);
                } else if (Area.TYPE_ITEM.equals(areaType)) {
                    return (T) JSON.toJavaObject(jsonObject, Item.class);
                }

                return null;
            }

            public int getFastMatchToken() {
                return JSONToken.LBRACE;
            }
        });


        Data data = JSON.parseObject(jsonData, Data.class);

        Item item = (Item) ((Floor)(data.areaList.get(0))).children.get(0);
    }
}
