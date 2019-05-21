package com.amyliascarlet.jsontest.bvt;

import java.lang.reflect.Field;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.SymbolTable;

import junit.framework.TestCase;

public class OOMTest extends TestCase {
    public void test_oom() throws Exception {
        
        for (int i = 0; i < 1000 * 1000; ++i) {
            String text = "{\"" + i + "\":0}";
            JSON.parse(text);
        }
        
        Field field = SymbolTable.class.getDeclaredField("symbols");
        field.setAccessible(true);
        Object[] symbols = (Object[]) field.get(ParserConfig.getGlobalInstance().symbolTable);
        Assert.assertEquals(4096, symbols.length);
    }
}
