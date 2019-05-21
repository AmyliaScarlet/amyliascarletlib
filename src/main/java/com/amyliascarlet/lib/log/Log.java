package com.amyliascarlet.lib.log;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日志类
 */
public class Log extends LogExpand implements LogInstance{

    private Log() {

    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    private static class SingletonHolder{
        private static final Log INSTANCE = new Log();

        private static final Log INSTANCE(Object obj) {
            return new Log(obj);
        }
    }

    public static Log getInstance()
    {
        if(Config.InstanceMode){
            return SingletonHolder.INSTANCE;
        }else {
            try {
                return Log.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                Config.InstanceMode= true;
                return SingletonHolder.INSTANCE;
            }
        }
    }

    public Log(Object obj){
        Config.logContent = obj.toString();
        Config._LogModel.Body = obj;
    }
    public Log(Boolean bGetInstance){
        Config.InstanceMode = bGetInstance;
    }
    public static synchronized void Instance(Boolean bGetInstance){
        Config.InstanceMode = bGetInstance;
    }
    public static synchronized void ShowType(Boolean bShowType){
        Config.ShowType = bShowType;
    }
    public static synchronized void Release(Boolean bReleaseMode) {
        Config.IsRelease = bReleaseMode;
    }
    public static synchronized void ShowHead(Boolean bShowHead) {
        Config.ShowHead = bShowHead;
    }
    public static synchronized void WriteDownAll(Boolean bWriteDownAll) {
        Config.WriteDownAll = bWriteDownAll;
    }
    public static synchronized void FileSaveRoot(String sFileSaveRoot) {
        Config.FileSaveRoot = sFileSaveRoot;
    }

    private static String Head(Tag tag,int nStackTraceLevel) {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        StringBuilder _sb = new StringBuilder();
        String sThreadName =Thread.currentThread().getName();

        _sb.append((new SimpleDateFormat(Config.sDateFormat)).format(new Date())).append(" [").append(sThreadName).append("] ");
        if (tag != null) {
            _sb.append(tag).append(" ");
            Config.nTag = tag;
        }

        _sb.append(stes[nStackTraceLevel].getClassName()).append("/").append(stes[nStackTraceLevel].getMethodName()).append(Config.sStartTag);
        Config._LogModel.Head = _sb.toString();
        return _sb.toString();
    }
    private static String Head(Tag tag) {
        return Head(tag,Config.DefaultStackTraceLevel);
    }
    private static void SetContent(Object obj) {
        if(obj != null){
            SetContent(obj,null);
        }
    }
    private static void SetContent(Object obj, Tag tag) {
        if(obj != null){
            if(tag != null) {
                Config.logContent = Head(tag,Config.DefaultStackTraceLevel) + obj.toString(); //*此处必填 层级虽然和默认一样 但是是因为填了第二参数少一步重载函数 才和默认一样 适用于追加函数
            }else{
                Config.logContent = obj.toString();
            }
            Config._LogModel.Body =obj;
            Config.logContentBody = obj.toString();
        }
    }

    private static void SetContent(Object obj, Tag tag,int nStackTraceLevel) {
        if(obj != null){
            if(tag != null) {
                Config.logContent = Head(tag,nStackTraceLevel) + obj.toString();
            }else{
                Config.logContent = obj.toString();
            }
            Config._LogModel.Body =obj;
            Config.logContentBody = obj.toString();
        }
    }

    private static synchronized Log Print(Object obj, Tag tag, Boolean bGetInstance){
        if(bGetInstance != null)
            Config.InstanceMode = bGetInstance;

        if (Config.IsRelease) {
            if (Config.ShowHead) {
                System.out.print(Head(tag));
            }
            System.out.println(Util.CastObject(obj));
            SetContent(Util.CastObject(obj),tag);
        }
        if(Config.WriteDownAll){
            WriteDownAll(Config.FileSaveRoot.equals("") ? Config.DefaultFileSaveRoot:Config.FileSaveRoot);
        }
        return ReturnObject(obj);
    }

    /**
     * 日志扩展抽象类实现
     */
    @Override
    public Object OutBody(){
        if(Config.ForceParse){
            return ForceCastObject(Config._LogModel.Body);
        }else{
            return Config.logContentBody;
        }
    }
    @Override
    public Object Out(){
        if(Config.ForceParse){
            return Config._LogModel.Head + ForceCastObject(Config._LogModel.Body);
        }else{
            return Config.logContent;
        }
    }
    @Override
    public String ParseBody(){
        if(Config.ForceParse){
            return ForceCastObject(Config._LogModel.Body).replaceAll("\\\\\"","\"").replaceAll("\\\\\\\\","\\\\");
        }else {
            return Config.logContentBody.replaceAll("\\\\\"","\"").replaceAll("\\\\\\\\","\\\\");
        }
    }
    @Override
    public String Parse(){
        if(Config.ForceParse){
            return Config._LogModel.Head + ForceCastObject(Config._LogModel.Body).replaceAll("\\\\\"","\"").replaceAll("\\\\\\\\","\\\\");
        }else {
            return Config.logContent.replaceAll("\\\\\"","\"").replaceAll("\\\\\\\\","\\\\");
        }
    }
    @Override
    public void ParsePrint(){
        if (Config.ShowHead) {
            System.out.print(Head(Config.nTag,Config.ForceStackTraceLevel));
        }
        System.out.println(ForceCastObject(Config._LogModel.Body).replaceAll("\\\\\"","\"").replaceAll("\\\\\\\\","\\\\").replaceAll("\\\\\"","\"").replaceAll("\\\\\\\\","\\\\"));
    }
    @Override
    public LogModel GetModel(){
        return Config._LogModel;
    }
    @Override
    public Log ForceParse(){
        Config.ForceParse = true;
        if(Config._LogModel != null && Config._LogModel.Body != null){
            if (Config.IsRelease) {
                if (Config.ShowHead) {
                    System.out.print(Head(Config.nTag,Config.ForceStackTraceLevel));
                }
                System.out.println(ForceCastObject(Config._LogModel.Body));
                SetContent(ForceCastObject(Config._LogModel.Body),Config.nTag,Config.ForceStackTraceLevel);
            }
            return ReturnObject(Config._LogModel.Head + Config._LogModel.Body);
        }
        return this;
    }

    public void WriteDown(){
        WriteDown("");
    }
    @Override
    public void WriteDown(String sFileName){
        if(Config._LogModel != null && Config._LogModel.Body != null){
            if(sFileName.equals(""))
                sFileName = Config.DefaultFileSaveRoot;
            WriteFile(Config._LogModel.Body ,sFileName,Config.ForceParse);
        }
    }
    public static void WriteDownAll(String sFileName){
        if(Config._LogModel != null && Config._LogModel.Body != null){
            WriteFile(Config._LogModel.Body ,sFileName,Config.ForceParse);
        }
    }

    /**
     * 日志主要函数静态实现
     */
    public static synchronized Log i(Object obj){
        Config._LogModel = new LogModel();
        Config.ForceParse = false;
        return Print(obj,Tag.INFO,null);
    }
    public static synchronized Log d(Object obj){

        Config.ForceParse = false;
        return Print(obj,Tag.DEBUG,null);
    }
    public static synchronized Log e(Object obj){
        Config.ForceParse = false;
        return Print(obj,Tag.ERROR,null);
    }
    public static synchronized Log w(Object obj){
        Config.ForceParse = false;
        return Print(obj,Tag.WARING,null);
    }
    public static synchronized Log SystemOutPrint(Object obj) {
        Config.ForceParse = false;
        System.out.println(obj);
        SetContent(obj);
        return ReturnObject(obj);
    }

    public static synchronized Log Write(Object obj,String sFileName){
        WriteFile(obj, sFileName);
        return ReturnObject(obj);
    }

    /**
     * 日志主要函数实例接口实现
     */
    @Override
    public Log i(Object obj,Boolean bGetInstance){
        Config.ForceParse = false;
        Print(obj,Tag.INFO,bGetInstance);
        return ReturnObject();
    }
    @Override
    public Log d(Object obj,Boolean bGetInstance){
        Config.ForceParse = false;
        Print(obj,Tag.DEBUG,bGetInstance);
        return ReturnObject();
    }
    @Override
    public Log e(Object obj,Boolean bGetInstance){
        Config.ForceParse = false;
        Print(obj,Tag.ERROR,bGetInstance);
        return ReturnObject();
    }
    @Override
    public Log w(Object obj,Boolean bGetInstance){
        Config.ForceParse = false;
        Print(obj,Tag.WARING,bGetInstance);
        return ReturnObject();
    }
    @Override
    public Log Write(Object obj,String sFileName,Boolean bGetInstance){
        Config.InstanceMode = bGetInstance;

        WriteFile(obj, sFileName);
        return ReturnObject();
    }
    @Override
    public Log SystemOutPrint(Object obj,Boolean bGetInstance){
        Config.ForceParse = false;
        Config.InstanceMode = bGetInstance;
        synchronized (this) {
            System.out.println(obj);
            SetContent(obj);
        }
        return ReturnObject();

    }
    private static void WriteFile(Object obj, String sFileName) {
        WriteFile(obj,sFileName,false);
    }
    private static void WriteFile(Object obj, String sFileName, boolean bForceParse) {
        try {
            File file = new File(sFileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter out = null;

            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
                out.write(Head(null,Config.DefaultStackTraceLevel));//*此处必填 层级虽然和默认一样 但是是因为填了第二参数少一步重载函数 才和默认一样 适用于写入文件
                if(bForceParse){
                    out.write(ForceCastObject(obj));
                }else {
                    out.write(Util.CastObject(obj));
                }
                out.write("\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    Objects.requireNonNull(out).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (LogException | IOException e) {
            e.printStackTrace();
            throw new LogException(e.getMessage());
        }
    }

    private Log ReturnObject() {
        if (!Config.InstanceMode) {
            try {
                synchronized (this) {
                    return Log.class.newInstance();
                }
            } catch (LogException | InstantiationException | IllegalAccessException e) {
                try {
                    finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    throw new LogException(throwable.getMessage(),throwable);
                }
                Config.InstanceMode = true;
                synchronized (this) {
                    return SingletonHolder.INSTANCE;
                }
            }
        }
        else {
            synchronized (this) {
                return SingletonHolder.INSTANCE;
            }
        }
    }
    private static Log ReturnObject(Object obj) {
        if (!Config.InstanceMode) {
            try {
                return Log.class.newInstance();
            } catch (LogException | InstantiationException | IllegalAccessException e) {
                Config.InstanceMode = true;
                return SingletonHolder.INSTANCE(obj);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                throw new LogException(throwable.getMessage(), throwable);
            }
        }else {
            return SingletonHolder.INSTANCE(obj);
        }
    }

}