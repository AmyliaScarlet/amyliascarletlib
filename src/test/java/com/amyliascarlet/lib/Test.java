package com.amyliascarlet.lib;


import com.amyliascarlet.lib.log.Log;
import com.amyliascarlet.lib.socket.SocketModel;
import junit.framework.TestCase;

import java.util.ArrayList;

public class Test extends TestCase {

    public void test_main() {
       int[] i = new int[]{2,3};

       SocketModel sm = new SocketModel();
        sm.a=2;
        sm.b="q";
        ArrayList<SocketModel> l = new ArrayList<>();

        l.add(sm);
        Log.i(l.get(0).a);

       add(l);
       Log.i(l.get(0).a);

    }

    public void add(ArrayList<SocketModel>  i){
        i.get(0).a ++;

    }
}
