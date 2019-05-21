package com.amyliascarlet.lib.log;

class Config {
     final static String NumberMatch = "[0-9]+.*[0-9]*";
     final static String sTrue = "true";
     final static String sFalse = "false";
     final static String sStartTag = ":: ";
     final static String sDateFormat = "MM-dd HH:mm:ss:SSS";
     final static String sSeparator = ", ";

     static boolean IsRelease = true;
     static boolean WriteDownAll = false;
     static boolean ShowHead = true;
     static boolean InstanceMode = true;
     static boolean ShowType = true;
     static boolean ForceParse = false;
     static String logContent;
     static String logContentBody;

     static Tag nTag = Tag.INFO;
     static int DefaultStackTraceLevel = 5;
     static int ForceStackTraceLevel = 3;

     static LogModel _LogModel = new LogModel();

     static String DefaultFileSaveRoot = System.getProperty("user.dir") + "\\" + "Log.log";
     static String FileSaveRoot = "";


}
