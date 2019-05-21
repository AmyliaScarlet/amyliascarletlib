package com.amyliascarlet.jsontest.test.vans;

import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.annotation.JSONType;

import java.io.Serializable;

@JSONType(orders = {"uvs","metadata","normals","name","faces","vertices"})
public class VansGeometryData implements Serializable{
    public float[][] uvs;

    @JSONField(name = "metadata")
    public VansGeometryDataMetaData metaData;

    public float[] normals;
    public String name;
    public int[] faces;
    public float[] vertices;

    public VansGeometryData(){

    }
}
