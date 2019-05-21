package com.amyliascarlet.lib.thread;

/**
 * 日志异常捕获
 */
public class ThreadException extends RuntimeException {
    public ThreadException(){
        super();
    }

    public ThreadException(String message){
        super(message);
    }

    public ThreadException(String message, Throwable cause){
        super(message, cause);
    }
}
