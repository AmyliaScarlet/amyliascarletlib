package com.amyliascarlet.jsontest.bvt.bug;

import org.junit.Assert;

import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.JavaBeanDeserializer;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;

import junit.framework.TestCase;

public class Bug_for_issue_372 extends TestCase {
    public void test_for_issue() throws Exception {
        ParserConfig config = new ParserConfig();
        ObjectDeserializer deser = config.getDeserializer(Model.class);
        Assert.assertEquals(JavaBeanDeserializer.class, deser.getClass());
    }
    
    @JSONType(asm=false)
    public static class Model {
        
    }
}
