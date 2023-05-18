package com.example.demo.dao;

import com.example.demo.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface CardRepository extends JpaRepository<Card, Integer> {

//    @Query(value = "INSERT INTO cards VALUES(:number, :created_date, :closed_date, :userid)",
//            nativeQuery = true)
//    Map<String, Object> addCardForUser(@Param("number") int number,
//                                       @Param("created_date") String created_date,
//                                       @Param("closed_date")String closed_date,
//                                       @Param("userid") int userid);

}
