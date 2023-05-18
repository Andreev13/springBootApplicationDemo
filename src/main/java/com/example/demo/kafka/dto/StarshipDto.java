package com.example.demo.kafka.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
@Data
public class StarshipDto {

    private String name;
    private String model;
}
