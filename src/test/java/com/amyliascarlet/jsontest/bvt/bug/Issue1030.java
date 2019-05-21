package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by wenshao on 13/03/2017.
 */
public class Issue1030 extends TestCase {
    public void test_for_issue() throws Exception {
        String DOC = "{\"books\":[{\"pageWords\":[{\"num\":10},{\"num\":15}]},{\"pageWords\":[{\"num\":20}]}]}";

        //fastjson包
        JSONObject result = JSONObject.parseObject(DOC);

        List array = (List) JSONPath.eval(result, "$.books[0:].pageWords[0:]");

        assertEquals(3, array.size());
    }
}
