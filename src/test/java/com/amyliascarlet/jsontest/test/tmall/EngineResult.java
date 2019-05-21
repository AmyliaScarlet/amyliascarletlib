package com.amyliascarlet.jsontest.test.tmall;

import com.amyliascarlet.lib.json.annotation.JSONField;

/**
 * User: jingxian.lzg
 * Date: 2015/9/1
 * Time: 16:55
 */
public class EngineResult {
    @JSONField(name = "pinglun")
    private RateResult rateResult;

    public RateResult getRateResult () {
        return rateResult;
    }

    public void setRateResult (RateResult rateResult) {
        this.rateResult = rateResult;
    }
}
