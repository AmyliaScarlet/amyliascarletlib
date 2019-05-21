package com.amyliascarlet.jsontest.bvt.parser;

import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

public class FeatureCountTest extends TestCase {
    public void testZ_0() throws Exception {
        Feature[] features = Feature.class.getEnumConstants();
        System.out.println(features.length);
        assertTrue(features.length < 32);
    }
}
