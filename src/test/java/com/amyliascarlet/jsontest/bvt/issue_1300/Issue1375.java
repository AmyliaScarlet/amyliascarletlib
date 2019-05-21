package com.amyliascarlet.jsontest.bvt.issue_1300;

import com.amyliascarlet.lib.json.serializer.CollectionCodec;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import junit.framework.TestCase;

import java.util.LinkedList;

/**
 * Created by wenshao on 06/08/2017.
 */
public class Issue1375 extends TestCase {
    public void test_issue() throws Exception {
        assertSame(CollectionCodec.instance
                , SerializeConfig.getGlobalInstance()
                        .getObjectWriter(LinkedList.class));
    }
}
