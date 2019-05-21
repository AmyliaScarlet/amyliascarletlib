package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;
import org.junit.Assert;

public class PrettyFormatTest2 extends TestCase {

    public void test_0() throws Exception {
        Model model = new Model();
        model.id = 123;
        model.name = "wenshao";
        String text = JSON.toJSONString(model, SerializerFeature.PrettyFormat);
        assertEquals("{\n" +
                "\t\"id\":123,\n" +
                "\t\"name\":\"wenshao\"\n" +
                "}", text);
        
        Assert.assertEquals("[\n\t{},\n\t{}\n]", JSON.toJSONString(new Object[] { new Object(), new Object() }, SerializerFeature.PrettyFormat));
    }

    public  static class Model {
        public int id;
        public String name;
    }
}
