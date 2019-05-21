package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.PascalNameFilter;

public class PascalNameFilterTest extends TestCase {

    public void test_0() throws Exception {
        JSONSerializer serializer = new JSONSerializer();
        serializer.getNameFilters().add(new PascalNameFilter());
        
        VO vo = new VO();
        vo.setId(123);
        vo.setName("wenshao");
        
        serializer.write(vo);

        Assert.assertEquals("{\"Id\":123,\"Name\":\"wenshao\"}", serializer.toString());
        
        serializer.close();
    }

    public static class VO {

        private int    id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
