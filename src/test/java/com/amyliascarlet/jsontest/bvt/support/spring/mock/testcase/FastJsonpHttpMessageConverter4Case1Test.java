package com.amyliascarlet.jsontest.bvt.support.spring.mock.testcase;

import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.support.spring.FastJsonpResponseBodyAdvice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath*:/config/applicationContext-mvc4.xml" })
public class FastJsonpHttpMessageConverter4Case1Test {
    private static final MediaType APPLICATION_JAVASCRIPT = new MediaType("application", "javascript");

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac) //
                .addFilter(new CharacterEncodingFilter("UTF-8", true)) // 设置服务器端返回的字符集为：UTF-8
                .build();
    }

    @Test
    public void isInjectComponent() {
        wac.getBean(FastJsonpResponseBodyAdvice.class);
    }

    @Test
    public void test1() throws Exception {

        JSONObject json = new JSONObject();

        json.put("id", 123);

        json.put("name", "哈哈哈");

        mockMvc.perform(
                (post("/json/test1").characterEncoding("UTF-8").content(json.toJSONString())
                        .contentType(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void test1_2() throws Exception {

        JSONObject json = new JSONObject();

        json.put("id", 123);

        json.put("name", "哈哈哈");

        ResultActions actions = mockMvc.perform((post("/json/test1?callback=fnUpdateSome").characterEncoding(
                "UTF-8").content(json.toJSONString()).contentType(MediaType.APPLICATION_JSON)));
        actions.andDo(print());
        actions.andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JAVASCRIPT))
                .andExpect(content().string("/**/fnUpdateSome({\"name\":\"哈哈哈\",\"id\":123})"));
    }

    @Test
    public void test2() throws Exception {

        String jsonStr = "[{\"name\":\"p1\",\"sonList\":[{\"name\":\"s1\"}]},{\"name\":\"p2\",\"sonList\":[{\"name\":\"s2\"},{\"name\":\"s3\"}]}]";

        mockMvc.perform(
                (post("/json/test2").characterEncoding("UTF-8").content(jsonStr)
                        .contentType(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void test2_2() throws Exception {

        String jsonStr = "[{\"name\":\"p1\",\"sonList\":[{\"name\":\"s1\"}]},{\"name\":\"p2\",\"sonList\":[{\"name\":\"s2\"},{\"name\":\"s3\"}]}]";

        ResultActions actions = mockMvc.perform((post("/json/test2?jsonp=fnUpdateSome").characterEncoding("UTF-8")
                .content(jsonStr).contentType(MediaType.APPLICATION_JSON)));
        actions.andDo(print());
        actions.andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JAVASCRIPT))
                .andExpect(content().string("/**/fnUpdateSome({\"p1\":1,\"p2\":2})"));
    }

    @Test
    public void test3() throws Exception {
        List<Object> list = this.mockMvc.perform(post("/json/test3")).andReturn().getResponse()
                .getHeaderValues("Content-Length");
        Assert.assertNotEquals(list.size(), 0);
    }

    @Test
    public void test3_2() throws Exception {
        ResultActions actions = this.mockMvc.perform(post("/json/test3?jsonp=fnUpdateSome"));
        actions.andDo(print());
        actions.andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JAVASCRIPT))
                .andExpect(content().string("/**/fnUpdateSome({})"));
    }

    @Test
    public void test4() throws Exception {

        String jsonStr = "{\"t\":{\"id\":123,\"name\":\"哈哈哈\"}}";

        mockMvc.perform(
                (post("/json/test4").characterEncoding("UTF-8").content(jsonStr)
                        .contentType(MediaType.APPLICATION_JSON))).andDo(print());
    }

    @Test
    public void test4_2() throws Exception {

        String jsonStr = "{\"t\":{\"id\":123,\"name\":\"哈哈哈\"}}";

        ResultActions actions = mockMvc.perform((post("/json/test4?callback=myUpdate").characterEncoding("UTF-8")
                .content(jsonStr).contentType(MediaType.APPLICATION_JSON)));
        actions.andDo(print());
        actions.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JAVASCRIPT))
                .andExpect(content().string("/**/myUpdate(\"{\\\"t\\\":{\\\"id\\\":123,\\\"name\\\":\\\"哈哈哈\\\"}}\")"));
    }

    @Test
    public void test5() throws Exception {

        String jsonStr = "{\"packet\":{\"smsType\":\"USER_LOGIN\"}}";

        mockMvc.perform(
                (post("/json/test5").characterEncoding("UTF-8").content(jsonStr)
                        .contentType(MediaType.APPLICATION_JSON))).andDo(print());
    }

    @Test
    public void test5_2() throws Exception {

        String jsonStr = "{\"packet\":{\"smsType\":\"USER_LOGIN\"}}";

        ResultActions actions = mockMvc.perform((post("/json/test5?callback=myUpdate").characterEncoding("UTF-8")
                .content(jsonStr).contentType(MediaType.APPLICATION_JSON)));
        actions.andDo(print());
        actions.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JAVASCRIPT))
                .andExpect(content().string("/**/myUpdate(\"{\\\"packet\\\":{\\\"smsType\\\":\\\"USER_LOGIN\\\"}}\")"));
    }
}
