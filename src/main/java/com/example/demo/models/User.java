package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    @OneToMany(
            mappedBy = "userid",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Card> cards;

    public User(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}

