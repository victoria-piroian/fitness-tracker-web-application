package com.example.backend.model.repository;

import com.example.backend.model.entity.Diet;
import com.example.backend.model.entity.UserMealKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietRepository extends JpaRepository<Diet, UserMealKey> {

    @Query(value = "SELECT clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat FROM Diet WHERE clientId = :clientId", nativeQuery = true)
    List<Diet> findWantedInfo(@Param("clientId") long clientId);

    @Query(value = "SELECT * from Diet d WHERE " +
            "lower(d.mealName) like lower(concat('%', :searchTerm, '%'))", nativeQuery = true)
    List<Diet> searchByName(@Param("searchTerm") String searchTerm);


}
