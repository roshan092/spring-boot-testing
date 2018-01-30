package com.roshan092.springboottesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRespondWith200() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/todo"))
                        .andReturn();
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void shouldRespondWithToDo() throws Exception {
        //language=JSON
        String expectedResponse = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Shopping\",\n" +
                "    \"description\": \"Buy Veggies\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Cleaning\",\n" +
                "    \"description\": \"Clean Fridge\"\n" +
                "  }\n" +
                "]\n";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/todo"))
                        .andReturn();
        JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), true);
    }
}
