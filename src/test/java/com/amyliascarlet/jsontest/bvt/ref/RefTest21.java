package com.amyliascarlet.jsontest.bvt.ref;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

/**
 * Created by wenshao on 16/8/23.
 */
public class RefTest21 extends TestCase {
    public void test_ref() throws Exception {
        String jsonTest = "{\"details\":{\"type\":{\"items\":{\"allOf\":[{\"$ref\":\"title\",\"required\":[\"iconImg\"]}]}}}}";
        JSONObject object = JSON.parseObject(jsonTest, Feature.DisableSpecialKeyDetect);
        System.out.println( object.get( "details"));
    }
}
