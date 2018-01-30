package com.roshan092.springboottesting.controller;

import com.roshan092.springboottesting.domain.ToDo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class ToDoController {

    @GetMapping("/todo")
    public List<ToDo> getToDo() {
        return asList(
                ToDo.builder().id(1).name("Shopping").description("Buy Veggies").build(),
                ToDo.builder().id(2).name("Cleaning").description("Clean Fridge").build()
        );
    }
}
