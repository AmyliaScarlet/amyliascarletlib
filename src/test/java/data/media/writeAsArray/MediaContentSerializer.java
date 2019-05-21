package data.media.writeAsArray;

import java.io.IOException;
import java.lang.reflect.Type;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.ObjectSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;

import data.media.Image;
import data.media.Media;
import data.media.MediaContent;

public class MediaContentSerializer implements ObjectSerializer {
    private MediaSerializer mediaSerilaizer = new MediaSerializer(); 
    private ImageSerializer imageSerilaizer = new ImageSerializer(); 

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        MediaContent entity = (MediaContent) object;

        SerializeWriter out = serializer.getWriter();
        out.write('[');
        
        mediaSerilaizer.write(serializer, entity.getMedia(), "media", Media.class, 0);
        out.write(',');
        
        out.write('[');
        for (int i = 0; i < entity.getImages().size(); ++i) {
            if (i != 0) {
                out.write(',');
            }
            Image image = entity.getImages().get(i);
            imageSerilaizer.write(serializer, image, i, fieldType, 0);
        }
        out.write(']');
        
        out.write(']');
    }

}