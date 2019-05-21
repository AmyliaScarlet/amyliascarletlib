package com.amyliascarlet.lib.datatable;

/**
 * 日志异常捕获
 */
public class DataTableException extends RuntimeException {
    public DataTableException(){
        super();
    }

    public DataTableException(String message){
        super(message);
    }

    public DataTableException(String message, Throwable cause){
        super(message, cause);
    }
}
