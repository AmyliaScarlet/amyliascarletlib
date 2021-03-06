package com.amyliascarlet.jsontest.bvt.bug;

import java.io.Serializable;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class Bug_for_stv_liu extends TestCase {
    protected void setUp() throws Exception {
        com.amyliascarlet.lib.json.parser.ParserConfig.global.addAccept("com.amyliascarlet.jsontest.bvt.bug.Bug_for_stv_liu.");
    }

    public void test() {
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        String json = JSON.toJSONString(user, SerializerFeature.WriteClassName);
        user = (User) JSON.parse(json);// 此处抛异常
        Assert.assertNotNull(user);
    }

    public static interface IdEntity<T extends Serializable> extends Serializable {

        T getId();

        void setId(T id);
    }

    public static class BaseEntity implements IdEntity<String> {

        private static final long serialVersionUID = 1L;
        private String            id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class User extends BaseEntity {

        private String username;

        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @param username the username to set
         */
        public void setUsername(String username) {
            this.username = username;
        }
    }
}
