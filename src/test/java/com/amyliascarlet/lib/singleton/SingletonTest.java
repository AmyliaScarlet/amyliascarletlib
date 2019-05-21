package com.amyliascarlet.lib.singleton;


import com.amyliascarlet.lib.bean.User;
import com.amyliascarlet.lib.log.Log;
import junit.framework.TestCase;

public class SingletonTest extends TestCase {
    public void test_enum() {


//        Object a = Singleton.getSingleton(User.class);
//        Object u = Singleton.getSingleton(User.class);
//
//        Log.i(a);
//        Log.i(u);
        Log.i(Singleton.getInstance().getSingleton(User.class)==Singleton.getInstance().getSingleton(User.class));



    }
}
