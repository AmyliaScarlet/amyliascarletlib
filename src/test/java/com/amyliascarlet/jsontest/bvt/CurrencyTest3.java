package com.amyliascarlet.jsontest.bvt;

import java.math.BigDecimal;
import java.util.Currency;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;


public class CurrencyTest3 extends TestCase {
    public static class Money {
        public Currency currency;
        public BigDecimal amount;

        @Override
        public String toString() {
            return "Money{currency=" + currency + ", amount=" + amount + '}';
        }
    }

    public void testJson() throws Exception {
        Money money = new Money();
        money.currency = Currency.getInstance("CNY");
        money.amount = new BigDecimal("10.03");

        String json = JSON.toJSONString(money);
        System.out.println("jsontest = " + json);

        Money moneyBack = JSON.parseObject(json, Money.class);
        System.out.println("money = " + moneyBack);

        JSONObject jsonObject = JSON.parseObject(json);
        Money moneyCast = JSON.toJavaObject(jsonObject, Money.class);
        System.out.printf("money = " + moneyCast);
    }
}
