package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.FieldSerializer;
import com.amyliascarlet.lib.json.serializer.JavaBeanSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.jsontest.bvtVO.alipay.PlatformDepartmentVO;
import junit.framework.TestCase;

import java.lang.reflect.Field;

public class Bug_for_yegaofei  extends TestCase {
    public void test_0() throws Exception {
        PlatformDepartmentVO vo = new PlatformDepartmentVO();
        vo.setId("xx");
        JSON.toJSONString(vo);
        JavaBeanSerializer serializer = (JavaBeanSerializer) SerializeConfig.globalInstance.getObjectWriter(PlatformDepartmentVO.class);
        Field field = JavaBeanSerializer.class.getDeclaredField("getters");
        field.setAccessible(true);
        FieldSerializer[] getters = (FieldSerializer[]) field.get(serializer);
        for (FieldSerializer getter : getters) {
            assertNotNull(getter);
        }
    }
}
