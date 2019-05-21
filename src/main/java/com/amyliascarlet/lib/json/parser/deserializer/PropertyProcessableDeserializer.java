package com.amyliascarlet.lib.json.parser.deserializer;

import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONToken;

import java.lang.reflect.Type;

/**
 * Created by wenshao on 15/07/2017.
 */
public class PropertyProcessableDeserializer implements ObjectDeserializer {
    public final Class<PropertyProcessable> type;

    public PropertyProcessableDeserializer(Class<PropertyProcessable> type) {
        this.type = type;
    }

    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        PropertyProcessable processable;
        try {
            processable = this.type.newInstance();
        } catch (Exception e) {
            throw new JSONException("craete instance error");
        }

        Object object =parser.parse(processable, fieldName);

        return (T) object;
    }

    public int getFastMatchToken() {
        return JSONToken.LBRACE;
    }
}