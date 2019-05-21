package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class Bug_for_issue_184 extends TestCase {
    protected void setUp() throws Exception {
        ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.bug.Bug_for_issue_184");
    }

    public void test_for_issue() throws Exception {
        TUser user = new TUser();
        user.id = 1001;
        // 禁用asm(在android下使用)，启用asm则没问题。
        SerializeConfig.getGlobalInstance().setAsmEnable(false);
        String json = JSON.toJSONString(user, SerializerFeature.WriteClassName);
        // 输出{"@type":"xx.TUser","id":0L}
        System.out.println(json);
        // 下面反系列化错误：com.amyliascarlet.json.JSONException: unclosed.str
        // 原因：id带L后缀
        user = (TUser) JSON.parse(json);
    }

    public static class TUser {

        public long id;
    }
}
