package com.amyliascarlet.jsontest.bvtVO.ae.huangliang2;

import com.amyliascarlet.lib.json.annotation.JSONType;

import java.util.List;

/**
 * Created by huangliang on 17/5/8.
 */
@JSONType(typeName = "section")
public class Section implements Area {
    public List<Area> children;

    public String type;

    public String templateId;

    @Override
    public String getName() {
        return templateId;
    }
}
