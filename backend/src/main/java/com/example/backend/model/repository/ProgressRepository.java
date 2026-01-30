package com.example.backend.model.repository;

import com.example.backend.model.entity.Progress;
import com.example.backend.model.entity.UserProgressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, UserProgressKey> {

    @Query(value = "SELECT * from Progress p WHERE " +
            "lower(p.goal) like lower(concat('%', :searchTerm, '%'))", nativeQuery = true)
    List<Progress> searchByName(@Param("searchTerm") String searchTerm);
}
