package com.amyliascarlet.jsontest.bvt.path;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONPath;
import com.amyliascarlet.lib.json.JSONPathException;

import junit.framework.TestCase;

public class JSONPath_1 extends TestCase {

    public void test_path_empty() throws Exception {
        Throwable error = null;
        try {
            JSONPath.compile("");
        } catch (JSONPathException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_path_null() throws Exception {
        Throwable error = null;
        try {
            JSONPath.compile(null);
        } catch (JSONPathException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
    
    public void test_path_null_1() throws Exception {
        Throwable error = null;
        try {
            new JSONPath(null);
        } catch (JSONPathException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }
}
