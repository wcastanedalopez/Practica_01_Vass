package com.example.projecttest01.repository;

import com.example.projecttest01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

//    List<User> findByTasksIsBetween();
//
//    List<User> findByCreationDateBetween(LocalDate startDate, LocalDate endDate);
//
//    public User updateById (User request, Long id);



}
