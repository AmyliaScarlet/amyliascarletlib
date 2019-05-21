package com.amyliascarlet.jsontest.bvt.parser.stream;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.JSONReaderScanner;

public class JSONReaderScannerTest extends TestCase {
	public void test_singleQuote() throws Exception {
		DefaultJSONParser parser = new DefaultJSONParser(new JSONReaderScanner("{'name':'张三\\'\\n\\r\\\"'}"));
		JSONObject json = parser.parseObject();
		Assert.assertEquals("张三\'\n\r\"", json.get("name"));
		parser.close();
	}
	
	public void test_doubleQuote() throws Exception {
		DefaultJSONParser parser = new DefaultJSONParser(new JSONReaderScanner("{\"name\":\"张三\\'\\n\\r\\\"\"}"));
		JSONObject json = parser.parseObject();
		Assert.assertEquals("张三\'\n\r\"", json.get("name"));
		parser.close();
	}
	
	public void test_doubleQuote_2() throws Exception {
		DefaultJSONParser parser = new DefaultJSONParser(new JSONReaderScanner("{name:\"张三\\'\\n\\r\\\"\"}"));
		JSONObject json = parser.parseObject();
		Assert.assertEquals("张三\'\n\r\"", json.get("name"));
		parser.close();
	}
}
