package com.amyliascarlet.lib.datetable;

import com.amyliascarlet.lib.bean.Bean;
import com.amyliascarlet.lib.bean.User;
import com.amyliascarlet.lib.datatable.DataRow;
import com.amyliascarlet.lib.datatable.DataTable;
import com.amyliascarlet.lib.log.Log;
import junit.framework.TestCase;

import java.util.List;
import java.util.Map;

public class DataTableTest extends TestCase {

    public void test_main() {
        DataTable dt = new DataTable();
        dt.addColumn("name",String.class);
        dt.addColumn("age",Integer.class);

        DataRow dr = dt.newRow();
        dr.setValue("name","nike");
        dr.setValue("age",13);

        DataRow dr2 = dt.newRow();
        dr2.setValue("name","ddd");
        dr2.setValue("age",15);


        dt.addRow(dr);
        dt.addRow(dr2);

        Log.i(dt.getDates());
        Log.i(dr.getItemMap());
        Log.i(dt.addColumn("ww",String.class));
        Log.i(dr.getItemMap());

    }
    public void test_CreateBean() {

        DataTable dt = new DataTable();
        dt.addColumn("name",String.class);
        dt.addColumn("age",Integer.class);
        dt.addColumn("money",Double.class);
        dt.addColumn("score",Integer.class);
        DataRow dr = dt.newRow();
        dr.setValue("name","nick");
        dr.setValue("age",12);
        dr.setValue("score",13);
        dr.setValue("money",15.5);
        dt.addRow(dr);

        DataRow dr2 = dt.newRow();
        dr2.setValue("name","nic3k");
        dr2.setValue("age",132);
        dr2.setValue("score",113);
        dr2.setValue("money",125.5);
        dt.addRow(dr2);
        List<Map<String, Object>> l = dt.getDates();

        System.out.print(l);
        System.out.print("\n");
        Log.i(l);

//        Log.i(dr);
        //User u  = Bean.CreateBean(l, User.class);

        DataRow ddr = dt.getRows().get(1);
        User u2  = Bean.CreateBean(ddr.getItemMap(), User.class);
        //Log.i(u);
        Log.i(u2);
    }

}
