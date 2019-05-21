package com.amyliascarlet.lib.bean;


import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.log.Log;
import junit.framework.TestCase;

import java.util.Map;

public class BeanTest extends TestCase {

    public void test_Bean() {
        User u = new User();

        u.setName("ASA");
        u.setAge(12);
        u.setMoney(1200.23);
        //u.setScore(15);

        Map<String, Object> mss = Bean.GetMap(u);

        mss.put("score",((int)(mss.get("score")) + 10));
        mss.put("money",((double)(mss.get("money")) * 2));

        User u2 = Bean.CreateBean(mss,User.class);

        Log.i(u);
        Log.i(JSONObject.toJSONString(mss)).ParsePrint();
        Log.i(u2);

    }
}
