package com.example.backend.model.repository;

import com.example.backend.model.entity.Exercise;
import com.example.backend.model.entity.UserExerciseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UserExerciseKey> {

    @Query(value = "SELECT * from Exercise e WHERE " +
            "lower(e.workoutName) like lower(concat('%', :searchTerm, '%'))", nativeQuery = true)
    List<Exercise> searchByName(@Param("searchTerm") String searchTerm);
}
