package com.amyliascarlet.lib.log;

/**
 * 日志异常捕获
 */
public class LogException  extends RuntimeException {

    public LogException(){
        super();
    }

    public LogException(String message){
        super(message);
    }

    public LogException(String message, Throwable cause){
        super(message, cause);
    }
}
