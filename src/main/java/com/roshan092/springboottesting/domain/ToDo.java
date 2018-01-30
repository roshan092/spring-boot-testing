package com.roshan092.springboottesting.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDo {
    private Integer id;
    private String name;
    private String description;
}
