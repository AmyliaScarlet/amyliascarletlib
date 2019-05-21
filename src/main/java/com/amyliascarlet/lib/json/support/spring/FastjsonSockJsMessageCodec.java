package com.amyliascarlet.lib.json.support.spring;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;

public class FastjsonSockJsMessageCodec extends AbstractSockJsMessageCodec {

    public String[] decode(String content) throws IOException {
        return JSON.parseObject(content, String[].class);
    }

    public String[] decodeInputStream(InputStream content) throws IOException {
        return JSON.parseObject(content, String[].class);
    }

    @Override
    protected char[] applyJsonQuoting(String content) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out);
            serializer.write(content);
            return out.toCharArrayForSpringWebSocket();
        } finally {
            out.close();
        }
    }

}
