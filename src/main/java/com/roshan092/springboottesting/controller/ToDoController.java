package com.roshan092.springboottesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

    @GetMapping("/todo")
    public void getToDo() {
    }
}
