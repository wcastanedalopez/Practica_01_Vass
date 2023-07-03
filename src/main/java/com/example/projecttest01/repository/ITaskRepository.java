package com.example.projecttest01.repository;

import com.example.projecttest01.models.Task;
import com.example.projecttest01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository <Task, Long> {
    //List<Task> findByUserAndStartDateBetween(User user, LocalDate startDate, LocalDate endDate);

}
