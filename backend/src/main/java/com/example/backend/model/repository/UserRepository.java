package com.example.backend.model.repository;

import com.example.backend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * from UserProfile u WHERE " +
            "lower(u.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "OR " +
            "lower(u.lastName) like lower(concat('%', :searchTerm, '%'))", nativeQuery = true)
    List<User> searchByName(@Param("searchTerm") String searchTerm);
}
