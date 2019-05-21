package com.amyliascarlet.jsontest.bvt.issue_1500;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class StringSerializer implements ObjectSerializer {

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        serializer.write(String.valueOf(object));
    }

}
