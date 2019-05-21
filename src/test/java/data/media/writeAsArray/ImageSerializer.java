package data.media.writeAsArray;

import java.io.IOException;
import java.lang.reflect.Type;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;

import data.media.Image;

public class ImageSerializer implements ObjectSerializer {

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        Image image = (Image) object;

        SerializeWriter out = serializer.getWriter();
        out.write('[');
        
        out.writeInt(image.getHeight());
        out.write(',');
        out.writeInt(image.getWidth());
        out.write(',');
        out.writeString(image.getSize().name(), ',');
        out.writeString(image.getTitle(), ',');
        out.writeString(image.getUri());
        
        out.write(']');
    }

}
