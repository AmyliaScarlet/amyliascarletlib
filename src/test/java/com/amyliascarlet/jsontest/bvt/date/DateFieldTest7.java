package com.amyliascarlet.jsontest.bvt.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SimpleDateFormatSerializer;

public class DateFieldTest7 extends TestCase {
    protected void setUp() throws Exception {
        JSON.defaultTimeZone = TimeZone.getTimeZone("Asia/Shanghai");
        JSON.defaultLocale = Locale.CHINA;
    }
    
	public void test_0() throws Exception {
		SerializeConfig config = new SerializeConfig();
		config.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd"));
		config.setAsmEnable(false);

		Entity object = new Entity();
		object.setValue(new Date());
		String text = JSON.toJSONString(object, config);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", JSON.defaultLocale);
        format.setTimeZone(JSON.defaultTimeZone);
		Assert.assertEquals("{\"value\":\"" + format.format(object.getValue()) + "\"}", text);
	}

	public static class Entity {
		private Date value;

		public Date getValue() {
			return value;
		}

		public void setValue(Date value) {
			this.value = value;
		}

	}
}
