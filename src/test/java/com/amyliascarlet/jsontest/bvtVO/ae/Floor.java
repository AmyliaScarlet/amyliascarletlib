package com.amyliascarlet.jsontest.bvtVO.ae;

import java.util.List;

/**
 * Created by huangliang on 17/5/8.
 */

public class Floor implements Area {
    public List<Area> children;

    public String name;

    public String getName() {
        return name;
    }
}
