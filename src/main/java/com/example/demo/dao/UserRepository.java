package com.example.demo.dao;

import com.example.demo.dto.UserCards;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "SELECT NEW com.example.demo.dto.UserCards(users.name, cards.number, cards.created_date, cards.closed_date) " +
//            "FROM users JOIN cards on cards.userid = users.id " +
//            "WHERE users.id = :id"
//    )
//    UserCards getUserCardById(@Param("id") Long id);

    @Query(value = "SELECT new com.example.demo.dto.UserCards(u.name, c.number, c.createdDate, c.closedDate) " +
            "FROM User u LEFT JOIN u.cards c " +
            "WHERE u.id = :id"
    )
    UserCards getUserCardById(@Param("id") Long id);

}
