package com.amyliascarlet.lib.log;

import com.amyliascarlet.lib.bean.User;
import com.amyliascarlet.lib.thread.EasyThreadModel;
import com.amyliascarlet.lib.thread.Status;
import junit.framework.TestCase;

import java.util.*;

public class LogTest  extends TestCase{

   public void test_1() {
      Map<Object,Object> a = new HashMap<>();
      Map<Object,Object> b = new HashMap<>();
      Map<String,String> aa = new HashMap<>();
      Map<String,String> bb = new HashMap<>();
      List<Integer> l = new ArrayList<>();

      l.add(66);
      l.add(55);
      l.add(44);
      String d = "{\"明天\"a\"sdsd}\"";
      aa.put(d,"1");
      aa.put("{\\\"aaa\\\":\\\"8\\\"}","{\"qq\":\"1233\"}");
      bb.put("bb","1");
      bb.put("bbb","2");
      a.put(33,aa);
      a.put("44","tttt");
      a.put("a3",bb);
      a.put(12,true);
      a.put("a5",32.78);
      a.put("a6",l);
      b.put("a","a1");
      b.put("b","a2");
      b.put("c","a3");
      b.put("d","a4");
      b.put("e",l);
      a.put(0,new Date());
      b.put(0,new Date());

      User u = new User();

      u.setName("a");
      u.setAge(12);
      EasyThreadModel lm = new EasyThreadModel();
      lm.Name="ssd";
      lm.Status = Status.Running;
      Log.i(lm);
      //Log.i(65);
      //Log.i("65");
   }
   public void test_enum() {
      User u = new User();

      u.setName("a");
      u.setAge(12);

      //Log.i(User.class);
      Log.i(5).ForceParse();
      Log.getInstance();
      Log.getInstance().i(3);
      Log.getInstance().i("33");
      Log.i(u).ForceParse().i(4);
      Log.i(DataType.class);
      Log.i(Tag.class);

   }
   public void test_Arrary() {
      int[] i = new int[]{3,4,5};
      String[] s = new String[]{"a","2","c"};
      User u = new User();
      String sss = "{\"aaa\":\"8\"}";
      String sss2 = "{\\\"aaa\\\":\\\"8\\\"}";

      u.setName("a");
      u.setAge(12);
      ArrayList al = new ArrayList();
      al.add(s);
      al.add(u);
      al.add(8);
      al.add(sss);
      al.add(sss2);
      al.add("p");

      Log.i(al).ForceParse().ParsePrint();
      Log.i(al).ParsePrint();

   }
   public void test_JavaBean() {
      User u = new User();

      u.setName("a");
      u.setAge(12);

      System.out.print(u+"\n");

      Log.i(11).WriteDown();
      Log.i(u).ForceParse().WriteDown();
      Log.i(22).Write("f","Log.log");
      Log.i(24).ForceParse().WriteDown();
      Log.i(33).WriteDown();
      test_JavaBean2();
   }

   public void test_JavaBean2() {
      User u = new User();

      u.setName("b");
      u.setAge(22);

      Log
              .i(u)
              .ForceParse().WriteDown();


   }

   public void test_data() {
      String a = "{\\\"aaa\\\":\\\"8\\\"}";

      Log.i(a).ParsePrint();
   }

   public void test_BasicDataMember() {

      Map<Object,Object> a = new HashMap<>();
      Map<Object,Object> b = new HashMap<>();
      Map<String,String> aa = new HashMap<>();
      Map<String,String> bb = new HashMap<>();
      List<Integer> l = new ArrayList<>();

      l.add(66);
      l.add(55);
      l.add(44);
      String d = "明\\天\"asd\"sd";
      aa.put(d,"1");
      aa.put("{\\\"aaa\\\":\\\"8\\\"}","{\"qq\":\"1233\"}");
      bb.put("bb","1");
      bb.put("bbb","2");
      a.put(33,aa);
      a.put("44","tttt");
      a.put("a3",bb);
      a.put(12,true);
      a.put("a5",32.78);
      a.put("a6",l);
      b.put("a","a1");
      b.put("b","a2");
      b.put("c","a3");
      b.put("d","a4");
      b.put("e",l);
      a.put(0,new Date());
      b.put(0,new Date());

      User u = new User();

      u.setName("a");
      u.setAge(12);


      Log.i(aa);
      System.out.print("\n【===================1=================】\n");
      Object w = Log.i(a).Out();
      System.out.print("\n【===================2=================】\n");
      System.out.print(w);
      System.out.print("\n【===================3=================】\n");
      String se =Log.i(a).Parse();
      System.out.print(se);
      System.out.print("\n【===================4=================】\n");
      Log.i(se);
      System.out.print("\n【===================5=================】\n");
      Log.i(w);
      System.out.print("\n【===================6=================】\n");

      Log.i(a).ParsePrint();

      System.out.print("\n【===================7=================】\n");
      Log.i(u);

      System.out.print("\n【===================8=================】\n");

      LogModel mmm = Log.i(123).GetModel();
      System.out.print("a="+mmm.Head+"\n");
      System.out.print("b="+mmm.Body+"\n");
      Log.i(a);
      System.out.print("a="+mmm.Head+"\n");
      System.out.print("b="+mmm.Body+"\n");


      System.out.print("\n");

      test_BasicDataMember2();

   }

   public void test_BasicDataMember2() {

      Map<Object,Object> a = new HashMap<>();
      Map<Object,Object> b = new HashMap<>();
      Map<String,String> aa = new HashMap<>();
      Map<String,String> bb = new HashMap<>();
      List<Integer> l = new ArrayList<>();

      l.add(66);
      l.add(55);
      l.add(44);
      String d = "{\"明天\"a\"sdsd}\"";
      aa.put(d,"1");
      aa.put("{\\\"aaa\\\":\\\"8\\\"}","{\"qq\":\"1233\"}");
      bb.put("bb","1");
      bb.put("bbb","2");
      a.put(33,aa);
      a.put("44","tttt");
      a.put("a3",bb);
      a.put(12,true);
      a.put("a5",32.78);
      a.put("a6",l);
      b.put("a","a1");
      b.put("b","a2");
      b.put("c","a3");
      b.put("d","a4");
      b.put("e",l);
      a.put(0,new Date());
      b.put(0,new Date());

      User u = new User();

      u.setName("a");
      u.setAge(12);

      Log.i(aa);
      System.out.print("\n【===================1=================】\n");
      Object w = Log.i(a).Out();
      System.out.print("\n【===================2=================】\n");
      System.out.print(w);
      System.out.print("\n【===================3=================】\n");
      String se =Log.i(a).Parse();
      System.out.print(se);
      System.out.print("\n【===================4=================】\n");
      Log.i(se);
      System.out.print("\n【===================5=================】\n");
      Log.i(w);
      System.out.print("\n【===================6=================】\n");

      Log.i(a).ParsePrint();

      System.out.print("\n【===================7=================】\n");
      Log.i(u);

      System.out.print("\n【===================8=================】\n");

      LogModel mmm = Log.i(123).GetModel();
      System.out.print("a="+mmm.Head+"\n");
      System.out.print("b="+mmm.Body+"\n");
      Log.i(a);
      System.out.print("a="+mmm.Head+"\n");
      System.out.print("b="+mmm.Body+"\n");

   }

   public void test_Print(){

      sss();

      pBean();

   }

   private static void pBean() {

      User u = (User) new User();

      u.setName("a");
      u.setMoney(12);

      Log.i(u).e(2);
   }

   private static void sss() {

      Map<Object,Object> a = new HashMap<>();
      Map<Object,Object> b = new HashMap<>();
      Map<String,String> aa = new HashMap<>();
      Map<String,String> bb = new HashMap<>();
      List<Integer> l = new ArrayList<>();

      l.add(66);
      l.add(55);
      l.add(44);
      String d = "明\\天\"asd\"sd";
      aa.put(d,"1");
      aa.put("{\\\"aaa\\\":\\\"8\\\"}","{\"qq\":\"1233\"}");
      bb.put("bb","1");
      bb.put("bbb","2");
      a.put(33,aa);
      a.put("44","tttt");
      a.put("a3",bb);
      a.put(12,true);
      a.put("a5",32.78);
      a.put("a6",l);
      b.put("a","a1");
      b.put("b","a2");
      b.put("c","a3");
      b.put("d","a4");
      b.put("e",l);
      a.put(0,new Date());
      b.put(0,new Date());

      System.out.print("\n【===================1=================】\n");
      Object w = Log.i(a).Out();
      System.out.print("\n【==================2==================】\n");
      System.out.print(w);
      System.out.print("\n【===================3=================】\n");
      String se =Log.d(a).Parse();
      System.out.print(se);
      System.out.print("\n【==================4==================】\n");
      Log.i(se);
      System.out.print("\n【===================5=================】\n");
      Log.i(w);
      System.out.print("\n【===================6=================】\n");

      Log.e(a).ParsePrint();

      System.out.print("\n【===================7=================】\n");

      LogModel mmm = Log.i(123).GetModel();
      System.out.print("a="+mmm.Head+"\n");
      System.out.print("b="+mmm.Body+"\n");
      Log.i(a);
      System.out.print("a="+mmm.Head+"\n");
      System.out.print("b="+mmm.Body+"\n");

   }

}




