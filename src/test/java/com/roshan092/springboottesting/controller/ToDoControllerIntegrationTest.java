package com.roshan092.springboottesting.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.roshan092.springboottesting.domain.ToDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnToDos() throws Exception {
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
        ResponseEntity<String> responseEntity =
                testRestTemplate.getForEntity("/todo", String.class);
        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), true);
        //Or you can use Json Path
        DocumentContext documentContext = JsonPath.parse(responseEntity.getBody());
        assertThat(documentContext.<List<Integer>>read("$..id")).contains(1, 2);
        assertThat(documentContext.<List<String>>read("$..name")).contains("Shopping", "Cleaning");
        assertThat(documentContext.<List<String>>read("$..description")).contains("Buy Veggies", "Clean Fridge");
    }
}
