package com.amyliascarlet.jsontest.bvt.writeClassName;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

import java.util.*;

public class WriteClassNameTest_Map extends TestCase {

    public void test_list() throws Exception {
        Model model = new Model();
        Map tables = new LinkedHashMap();
        tables.put("1001", new ExtTable(1001));
        tables.put("1002", new Table());
        model.setTables(tables);

        String json = JSON.toJSONString(model);
        assertEquals("{\"tables\":{\"1001\":{\"@type\":\"com.amyliascarlet.jsontest.bvt.writeClassName.WriteClassNameTest_Map$ExtTable\",\"id\":1001},\"1002\":{}}}", json);

        JSONObject jsonObject = JSON.parseObject(json, Feature.IgnoreAutoType);
        assertEquals("{\"tables\":{\"1002\":{},\"1001\":{\"id\":1001}}}", jsonObject.toJSONString());

        Model model2 = JSON.parseObject(json, Model.class);
        assertEquals(ExtTable.class, model2.getTables().get("1001").getClass());
    }

    public static class Model {
        @JSONField(serialzeFeatures = SerializerFeature.WriteClassName)
        private Map<String, ? extends Table> tables;

        public Map<String, ? extends Table> getTables() {
            return tables;
        }

        public void setTables(Map<String, ? extends Table> tables) {
            this.tables = tables;
        }
    }

    public static class Table {

    }

    public static class ExtTable extends Table {
        public int id;

        public ExtTable() {

        }

        public ExtTable(int id) {
            this.id = id;
        }
    }
}
