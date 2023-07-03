package com.example.projecttest01.services;

import com.example.projecttest01.models.Task;
import com.example.projecttest01.models.User;

import java.time.LocalDate;
import java.util.List;

public interface ITaskService {

    Task save(Task task);
    public List<Task> saveTasks (List<Task> listTasks);
    public Task updateById (Task request, Long id);
    List<Task> findAll();
    //List<Task> findByUserAndStartDateBetween(User user, LocalDate startDate, LocalDate endDate);



}
