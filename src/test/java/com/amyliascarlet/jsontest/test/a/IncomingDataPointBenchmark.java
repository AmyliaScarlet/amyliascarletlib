package com.amyliascarlet.jsontest.test.a;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.bvtVO.IncomingDataPoint;

/**
 * Created by wenshao on 04/08/2017.
 */
public class IncomingDataPointBenchmark {
    static String json = "[[\"DataAdaptor.LbMultiGroupPersonalityDataAdaptor.stddev.aggregate_sum\",\"1501812639932\",\"95.52667633256902\",{\"appName\":\"aladdin\",\"hostIdc\":\"et2\",\"hostunit\":\"CENTER\",\"nodegroup\":\"aladdin_prehost\",\"idc\":\"ET2\",\"agg_version\":\"100\",\"group\":\"DEFAULT\"},\"\",\"\",\"\"]]";

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; ++i) {
            perf();
        }
    }

    public static void perf() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; ++i) {
            JSON.parseArray(json, IncomingDataPoint.class);
        }
        long millis = System.currentTimeMillis() - start;
        System.out.println("millis : " + millis);
    }
}
