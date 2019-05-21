package com.amyliascarlet.lib.log;

import com.amyliascarlet.lib.datatable.DataColumn;
import com.amyliascarlet.lib.datatable.DataRow;
import com.amyliascarlet.lib.datatable.DataTable;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;


import java.lang.reflect.Field;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.amyliascarlet.lib.bean.Bean.isJavaBean;

class Util {
    static boolean isNumeric(Object obj){
        if(!(obj instanceof String)){
            Pattern pattern = Pattern.compile(Config.NumberMatch);
            Matcher isNum = pattern.matcher(obj.toString());
            return isNum.matches();
        }
        return false;
    }
    static boolean isJSONObject(String test) {
        try {
            JSONObject.parseObject(test);
        } catch (JSONException ex) {
            return false;
        }
        catch (Exception e){
            throw new LogException(e.getMessage());
        }
        return true;
    }
    static boolean isJSONArray(String test) {
        try {
            JSONObject.parseArray(test);
        } catch (JSONException ex1) {
            return false;
        }catch (Exception e){
            throw new LogException(e.getMessage());
        }
        return true;
    }
    static boolean isEnum(Object obj){
        return (((Class)obj).getEnumConstants() != null);
    }

    static boolean isModel(Object obj) {
        return obj.getClass().getDeclaredMethods().length<=0;
    }


    static String GetModelFields(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        HashMap<String, Object> map = new HashMap<>();
        for(int i = 0 , len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o;
                try {
                    o = fields[i].get(obj);
                    if(o instanceof String)
                        o = o.toString();
                    else
                        o = CastObject(o);
                    map.put(varName,o);
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
        return JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue).replaceAll("\\\\\"","\"").replaceAll("\\\\\\\\","\\\\");
    }

    static String CastObject(Object obj) {
        return CastObject(obj,false);
    }

    @SuppressWarnings("unchecked")
    private static String CastObject(Object obj, boolean IsRecursion) {

        StringBuilder _sb = new StringBuilder();

        if(obj != null){
            try {
                if(obj instanceof Class){
                    if(Util.isEnum(obj)){
                        if(Config.ShowType)
                            _sb.append(DataType.Enum);
                        _sb.append("[");
                        for(Object v : (((Class)obj).getEnumConstants())) {
                            _sb.append(CastObject(v,true)).append(Config.sSeparator);
                        }
                        CutLastSeparator(_sb);

                        _sb.append("]");

                    }else {
                        _sb.append(obj.toString().replace("class",DataType.Class));
                    }
                }else{
                    if (obj instanceof Boolean){
                        if(Config.ShowType)
                            _sb.append(DataType.Boolean);
                        _sb.append((Boolean)obj?Config.sTrue:Config.sFalse);
                    }else if(obj.getClass().isArray()){
                        if(Config.ShowType)
                            _sb.append(DataType.Array);
                        _sb.append(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue));
                    } else if(obj instanceof ArrayList){
                        if(Config.ShowType)
                            _sb.append(DataType.ArrayList);
                        _sb.append("[");
                        for(Object attribute : (ArrayList)obj) {
                            _sb.append(CastObject(attribute,true)).append(Config.sSeparator);
                        }
                        CutLastSeparator(_sb);
                        _sb.append("]");
                    }else if(obj instanceof List){
                        if(Config.ShowType)
                            _sb.append(DataType.List);
                        _sb.append("[");
                        for(Object attribute : (List)obj) {
                            _sb.append(CastObject(attribute,true)).append(Config.sSeparator);
                        }
                        CutLastSeparator(_sb);
                        _sb.append("]");
                    }else if(obj instanceof Map){
                        if(Config.ShowType)
                            _sb.append(DataType.Map);

                        _sb.append("{");
                        for (Object k : ((Map)obj).keySet()) {
                            Object v = ((Map)obj).get(k);
                            _sb.append(CastObject(k,true));
                            _sb.append(": ");
                            _sb.append(CastObject(v,true));
                            _sb.append(Config.sSeparator);
                        }
                        CutLastSeparator(_sb);
                        _sb.append("}");
                    }else if(Util.isNumeric(obj.toString())){
                        _sb.append(obj.toString());
                    }else if(obj instanceof Date){
                        if(Config.ShowType)
                            _sb.append(DataType.Date);
                        _sb.append(obj.toString());
                    }else if(obj instanceof String){

                        _sb.append("\"");

                        if(IsRecursion)
                            _sb.append(obj.toString());
                        else
                            _sb.append(obj.toString().replaceAll("\\\\","\\\\\\\\").replaceAll("\"","\\\\\""));
                        _sb.append("\"");
                    }else {
                        boolean bJavaBean = false;
                        boolean bDataTableObject = false;
                        if(isJavaBean(obj)){
                            bJavaBean = true;
                        }

                        if(Util.isJSONObject(obj.toString())){
                            bJavaBean = false;
                            if(Config.ShowType)
                                _sb.append(DataType.JSONObject);
                        }else{
                            if(Util.isJSONArray(obj.toString())){
                                bJavaBean = false;
                                if(Config.ShowType)
                                    _sb.append(DataType.JSONArray);
                            }else {
                                if((obj instanceof DataTable) || (obj instanceof DataRow) || (obj instanceof DataColumn)){
                                    bDataTableObject = true;
                                    bJavaBean = false;
                                    if(Config.ShowType)
                                        _sb.append(DataType.DataTable);
                                }
                            }
                        }

                        if(bJavaBean){
                            if(Config.ShowType)
                                _sb.append(DataType.JavaBean);
                            _sb.append(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue));
                        }else if(Util.isModel(obj)){
                            if(Config.ShowType)
                                _sb.append(DataType.Model);
                            _sb.append(Util.GetModelFields(obj));
                        }else if(bDataTableObject){
                            _sb.append(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue));
                        }else {
                            if(IsRecursion)
                                _sb.append(obj.toString());
                            else
                                _sb.append(obj.toString().replaceAll("\\\\","\\\\\\\\").replaceAll("\"","\\\\\""));
                        }
                    }

                }

            }catch (Exception e){
                e.printStackTrace();
                throw new LogException(e.getMessage());
            }

        }else {
            _sb.append(DataType.NULL);
        }

        return _sb.toString().replace("\""+DataType.NULL+"\"",DataType.NULL);
    }

    /** 地址引用不用返回StringBuilder **/
    private static void CutLastSeparator(StringBuilder _sb) {
        int nSprtorlen = Config.sSeparator.length();
        if(Config.ShowType){
            if(_sb.toString().substring(_sb.toString().indexOf(")")).length() > nSprtorlen)
                _sb.setLength(_sb.length() - nSprtorlen);
        }else {
            if(_sb.toString().length() > nSprtorlen)
                _sb.setLength(_sb.length() - nSprtorlen);
        }
    }

}
