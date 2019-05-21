package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.parser.ParserConfig;
import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.jsontest.test.dubbo.HelloServiceImpl;
import com.amyliascarlet.jsontest.test.dubbo.Tiger;
import com.amyliascarlet.jsontest.test.dubbo.Tigers;


public class Bug_for_dubbo extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.test.dubbo.Tigers");
    }

    public void test_0 () throws Exception {
        HelloServiceImpl helloService = new HelloServiceImpl();
        
        Tiger tiger = new Tiger();
        tiger.setTigerName("东北虎");
        tiger.setTigerSex(true);
        //Tiger tigers = helloService.eatTiger(tiger).getTiger();
        
        Tigers tigers = helloService.eatTiger(tiger);
        Assert.assertNotNull(tigers.getTiger());
        
        String text = JSON.toJSONString(tigers, SerializerFeature.WriteClassName);
        
        System.out.println(text);
        Tigers tigers1 = (Tigers) JSON.parse(text);
        Assert.assertNotNull(tigers1.getTiger());
    }
}
