package com.amyliascarlet.lib.json.util;

import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONArray;
import com.amyliascarlet.lib.json.JSONAware;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPath;
import com.amyliascarlet.lib.json.JSONPathException;
import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.JSONStreamAware;
import com.amyliascarlet.lib.json.JSONWriter;
import com.amyliascarlet.lib.json.TypeReference;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.parser.JSONLexer;
import com.amyliascarlet.lib.json.parser.JSONLexerBase;
import com.amyliascarlet.lib.json.parser.JSONReaderScanner;
import com.amyliascarlet.lib.json.parser.JSONScanner;
import com.amyliascarlet.lib.json.parser.JSONToken;
import com.amyliascarlet.lib.json.parser.ParseContext;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.parser.SymbolTable;
import com.amyliascarlet.lib.json.parser.deserializer.AutowiredObjectDeserializer;
import com.amyliascarlet.lib.json.parser.deserializer.DefaultFieldDeserializer;
import com.amyliascarlet.lib.json.parser.deserializer.ExtraProcessable;
import com.amyliascarlet.lib.json.parser.deserializer.ExtraProcessor;
import com.amyliascarlet.lib.json.parser.deserializer.ExtraTypeProvider;
import com.amyliascarlet.lib.json.parser.deserializer.FieldDeserializer;
import com.amyliascarlet.lib.json.parser.deserializer.JavaBeanDeserializer;
import com.amyliascarlet.lib.json.parser.deserializer.ObjectDeserializer;
import com.amyliascarlet.lib.json.serializer.AfterFilter;
import com.amyliascarlet.lib.json.serializer.BeanContext;
import com.amyliascarlet.lib.json.serializer.BeforeFilter;
import com.amyliascarlet.lib.json.serializer.ContextObjectSerializer;
import com.amyliascarlet.lib.json.serializer.ContextValueFilter;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.JavaBeanSerializer;
import com.amyliascarlet.lib.json.serializer.LabelFilter;
import com.amyliascarlet.lib.json.serializer.Labels;
import com.amyliascarlet.lib.json.serializer.NameFilter;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;
import com.amyliascarlet.lib.json.serializer.PropertyFilter;
import com.amyliascarlet.lib.json.serializer.PropertyPreFilter;
import com.amyliascarlet.lib.json.serializer.SerialContext;
import com.amyliascarlet.lib.json.serializer.SerializeBeanInfo;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializeFilter;
import com.amyliascarlet.lib.json.serializer.SerializeFilterable;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.lib.json.serializer.ValueFilter;

public class ASMClassLoader extends ClassLoader {

    private static java.security.ProtectionDomain DOMAIN;
    
    private static Map<String, Class<?>> classMapping = new HashMap<String, Class<?>>();

    static {
        DOMAIN = (java.security.ProtectionDomain) java.security.AccessController.doPrivileged(new PrivilegedAction<Object>() {

            public Object run() {
                return ASMClassLoader.class.getProtectionDomain();
            }
        });
        
        Class<?>[] jsonClasses = new Class<?>[] {JSON.class,
            JSONObject.class,
            JSONArray.class,
            JSONPath.class,
            JSONAware.class,
            JSONException.class,
            JSONPathException.class,
            JSONReader.class,
            JSONStreamAware.class,
            JSONWriter.class,
            TypeReference.class,
                    
            FieldInfo.class,
            TypeUtils.class,
            IOUtils.class,
            IdentityHashMap.class,
            ParameterizedTypeImpl.class,
            JavaBeanInfo.class,
                    
            ObjectSerializer.class,
            JavaBeanSerializer.class,
            SerializeFilterable.class,
            SerializeBeanInfo.class,
            JSONSerializer.class,
            SerializeWriter.class,
            SerializeFilter.class,
            Labels.class,
            LabelFilter.class,
            ContextValueFilter.class,
            AfterFilter.class,
            BeforeFilter.class,
            NameFilter.class,
            PropertyFilter.class,
            PropertyPreFilter.class,
            ValueFilter.class,
            SerializerFeature.class,
            ContextObjectSerializer.class,
            SerialContext.class,
            SerializeConfig.class,
                    
            JavaBeanDeserializer.class,
            ParserConfig.class,
            DefaultJSONParser.class,
            JSONLexer.class,
            JSONLexerBase.class,
            ParseContext.class,
            JSONToken.class,
            SymbolTable.class,
            Feature.class,
            JSONScanner.class,
            JSONReaderScanner.class,
                    
            AutowiredObjectDeserializer.class,
            ObjectDeserializer.class,
            ExtraProcessor.class,
            ExtraProcessable.class,
            ExtraTypeProvider.class,
            BeanContext.class,
            FieldDeserializer.class,
            DefaultFieldDeserializer.class,
        };
        
        for (Class<?> clazz : jsonClasses) {
            classMapping.put(clazz.getName(), clazz);
        }
    }
    
    public ASMClassLoader(){
        super(getParentClassLoader());
    }

    public ASMClassLoader(ClassLoader parent){
        super (parent);
    }

    static ClassLoader getParentClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(JSON.class.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException e) {
                // skip
            }
        }
        return JSON.class.getClassLoader();
    }

    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> mappingClass = classMapping.get(name);
        if (mappingClass != null) {
            return mappingClass;
        }
        
        try {
            return super.loadClass(name, resolve);
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    public Class<?> defineClassPublic(String name, byte[] b, int off, int len) throws ClassFormatError {
        Class<?> clazz = defineClass(name, b, off, len, DOMAIN);

        return clazz;
    }

    public boolean isExternalClass(Class<?> clazz) {
        ClassLoader classLoader = clazz.getClassLoader();

        if (classLoader == null) {
            return false;
        }

        ClassLoader current = this;
        while (current != null) {
            if (current == classLoader) {
                return false;
            }

            current = current.getParent();
        }

        return true;
    }

}
