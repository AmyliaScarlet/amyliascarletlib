package com.amyliascarlet.jsontest.bvt.parser.stream;

import java.io.StringReader;

import org.junit.Assert;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.parser.Feature;

public class JSONReaderTest_0 extends TestCase {
	public void test_read() throws Exception {
		JSONReader reader = new JSONReader(new StringReader("{}"));
		reader.config(Feature.AllowArbitraryCommas, true);
		
		JSONObject object = (JSONObject) reader.readObject();
		Assert.assertNotNull(object);
		
		reader.close();
	}
}
