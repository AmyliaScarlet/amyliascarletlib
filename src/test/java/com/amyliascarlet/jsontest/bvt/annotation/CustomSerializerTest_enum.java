package com.amyliascarlet.jsontest.bvt.annotation;

import java.io.IOException;
import java.lang.reflect.Type;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.serializer.JSONSerializable;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;

import junit.framework.TestCase;

public class CustomSerializerTest_enum extends TestCase {

    public void test_0() throws Exception {
        Model model = new Model();
        model.id = 1001;
        model.orderType = OrderType.PayOrder;
        String text = JSON.toJSONString(model);
//        Assert.assertEquals("{\"id\":1001,\"orderType\":{\"remark\":\"支付订单\",\"value\":1}}", text);
    }

    public static class Model {
        public int id;
        public OrderType orderType;
    }

    public static enum OrderType implements JSONSerializable {
                                  PayOrder(1, "支付订单"), //
                                  SettleBill(2, "结算单");

        public final int    value;
        public final String remark;

        private OrderType(int value, String remark){
            this.value = value;
            this.remark = remark;
        }

        @Override
        public void write(JSONSerializer serializer, Object fieldName, Type fieldType,
                          int features) throws IOException {
            JSONObject json = new JSONObject();
            json.put("value", value);
            json.put("remark", remark);
            serializer.write(json);
        }

    }

}
