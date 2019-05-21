package com.amyliascarlet.lib.log;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

/**
 * 日志扩展抽象类
 * 可追加额外的方法
 */
abstract class LogExpand {

    LogExpand() {
    }

    //返回数据体
    public abstract Object OutBody();

    //返回数据
    public abstract Object Out();

    //解析数据体
    public abstract String ParseBody();

    //解析数据
    public abstract String Parse();

    //解析后打印
    public abstract void ParsePrint();

    //获取最近Log的Model
    public abstract LogModel GetModel();

    //强制解析
    public abstract Log ForceParse();
    //强制解析对象
    static String ForceCastObject(Object obj) {
        StringBuilder _sb = new StringBuilder();

        if (obj != null) {
            try {
                _sb.append(DataType.ForceParse);
                _sb.append(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue));
            }catch (Exception e){
                e.printStackTrace();
                throw new LogException(e.getMessage());
            }

        }else {
            _sb.append(DataType.NULL);
        }

        return _sb.toString();
    }

    //记录打印的日志到文件
    public abstract void WriteDown(String sFileName);



}