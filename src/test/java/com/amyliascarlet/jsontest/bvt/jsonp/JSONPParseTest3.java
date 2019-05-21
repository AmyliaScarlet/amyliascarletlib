package com.amyliascarlet.jsontest.bvt.jsonp;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPObject;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import junit.framework.TestCase;

/**
 * Created by wenshao on 21/02/2017.
 */
public class JSONPParseTest3 extends TestCase {
    public void test_f() throws Exception {
        String text = "parent.callback ({'id':1, 'name':'ido)nans'},1,2 );   /**/ ";

        JSONPObject jsonpObject = (JSONPObject) JSON.parseObject(text, JSONPObject.class);
        assertEquals("parent.callback", jsonpObject.getFunction());

        assertEquals(3, jsonpObject.getParameters().size());
        JSONObject param = (JSONObject) jsonpObject.getParameters().get(0);
        assertEquals(1, param.get("id"));
        assertEquals("ido)nans", param.get("name"));

        String json = JSON.toJSONString(jsonpObject, SerializerFeature.BrowserSecure);
        assertEquals("/**/parent.callback({\"name\":\"ido\\u0029nans\",\"id\":1},1,2)", json);
    }
}
