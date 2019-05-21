package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.jsontest.bvtVO.IEvent;
import com.amyliascarlet.jsontest.bvtVO.IEventDto;

public class Bug_for_hmy8 extends TestCase {

    public void test_ser() throws Exception {
        IEventDto dto = new IEventDto();
        dto.getEventList().add(new IEvent());
        
        JSON.toJSONString(dto);
    }
}
