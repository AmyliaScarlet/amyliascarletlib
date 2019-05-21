package com.amyliascarlet.lib.log;

/**
 * 日志主要函数实例接口
 */
interface LogInstance {
    Log i(Object obj,Boolean bGetInstance);
    Log w(Object obj,Boolean bGetInstance);
    Log e(Object obj,Boolean bGetInstance);
    Log d(Object obj,Boolean bGetInstance);

    Log Write(Object obj,String sFileName,Boolean bGetInstance);

    Log SystemOutPrint(Object obj,Boolean bGetInstance);
}
