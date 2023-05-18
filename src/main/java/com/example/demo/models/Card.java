package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="cards")
@Data
@NoArgsConstructor
public class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "closed_date")
    private String closedDate;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
//            optional = false
    )
    @JsonIgnore
    @JoinColumn(name = "userid")
    private User userid;

}
