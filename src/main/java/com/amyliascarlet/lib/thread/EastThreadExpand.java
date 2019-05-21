package com.amyliascarlet.lib.thread;

import java.util.IdentityHashMap;

abstract class EastThreadExpand {

    public abstract IdentityHashMap<String, EasyThreadModel> getEasyThreadModels();

    public abstract void remove(EasyThreadModel easyThreadModel);

    public abstract void execute(EasyThreadModel easyThreadModel);

}
