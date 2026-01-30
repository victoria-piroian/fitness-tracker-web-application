package com.example.backend.model.repository;

import com.example.backend.model.entity.Sleep;
import com.example.backend.model.entity.UserSleepKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SleepRepository extends JpaRepository<Sleep, UserSleepKey> {

    @Query(value = "SELECT * from Sleep s WHERE " +
            "lower(s.dayYear) like lower(concat('%', :searchTerm, '%'))", nativeQuery = true)
    List<Sleep> searchByName(@Param("searchTerm") String searchTerm);
}
