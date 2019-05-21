package com.amyliascarlet.jsontest.bvt;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.fail;

public class Bug89 {
    @Test
    public void testBug89() {
        try {
            String s = "{\"a\":з」∠)_,\"}";
            JSON.parseObject(s);
            fail("Expect JSONException");
        } catch (JSONException e) {
            // good
        }
    }
}
