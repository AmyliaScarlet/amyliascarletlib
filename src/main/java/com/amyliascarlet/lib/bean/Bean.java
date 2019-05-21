package com.amyliascarlet.lib.bean;

import com.amyliascarlet.lib.datatable.DataRow;
import com.amyliascarlet.lib.datatable.DataTable;
import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.deserializer.JavaBeanDeserializer;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Bean {

    public static boolean isJavaBean(Object obj){
        boolean flag = false;

        if(!(ParserConfig.global.getDeserializer(obj.getClass().getSuperclass()) instanceof JavaBeanDeserializer)){
            Method[] methods = obj.getClass().getDeclaredMethods();
            String nameaft="";
            for (Method m : methods)
            {
                String name = m.getName();
                if (name.toLowerCase().contains("set")) {
                    nameaft = name.substring(name.toLowerCase().indexOf("set")+3);
                    if(!nameaft.equals("Signers")) //排除setSigners getSigners
                        break;
                }
            }
            if(nameaft.length()>0 && !nameaft.equals("Signers")){
                for (Method m : methods){
                    String name = m.getName();
                    if(name.toLowerCase().contains(("get"+nameaft).toLowerCase())){
                        flag = true;
                    }
                }
            }
        }
        return  flag;
    }

    public static  <T> T CreateBean(Object obj, Class<T> entityClass){
        return Object2Bean(obj,entityClass);
    }

    public static <T> T GetMap(Object obj){
        try {
            return (T) Bean2Map(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static <T> T Object2Bean(Object object, Class<T> entityClass) {
        if(null == object) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(object), entityClass);
    }


    private static Map<String, Object> Bean2Map(Object obj) {

        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                if (!key.equals("class")) {
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }
}
