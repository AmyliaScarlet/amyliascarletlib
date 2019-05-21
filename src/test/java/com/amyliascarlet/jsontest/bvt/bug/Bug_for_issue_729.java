package com.amyliascarlet.jsontest.bvt.bug;

import java.io.Serializable;
import java.util.Date;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;

import junit.framework.TestCase;

public class Bug_for_issue_729 extends TestCase {

    public void test_for_issue() throws Exception {
        Person person = new Person();
        person.setName("bob");
        person.startTime = new Date();

        String result = JSON.toJSONString(person);
        Person person2 = JSON.parseObject(result, Person.class);
        person2.toString();
    }

    public static class Person implements Serializable {

        public String name;

        @JSONField(format = "yyyy-MM-dd HH:mm")
        public Date   startTime;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", startTime=" + startTime + "]";
        }

    }
}
