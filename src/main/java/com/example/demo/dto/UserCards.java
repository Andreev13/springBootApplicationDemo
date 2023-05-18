package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserCards {

    private String name;
    private Integer number;
    private String created_date;
    private String closed_date;

    public UserCards(String name, Integer number, String created_date, String closed_date) {
        this.name = name;
        this.number = number;
        this.created_date = created_date;
        this.closed_date = closed_date;
    }
}
