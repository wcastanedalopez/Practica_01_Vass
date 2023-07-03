package com.example.projecttest01.services;

import com.example.projecttest01.exception.EmailAlreadyExistsException;
import com.example.projecttest01.exception.IdAlreadyExistsException;
import com.example.projecttest01.exception.UserNotFoundException;
import com.example.projecttest01.models.Task;
import com.example.projecttest01.models.User;
import com.example.projecttest01.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService{

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        if(taskRepository.existsById(task.getId()))
            throw new IdAlreadyExistsException( "Task already");

        return taskRepository.save(task);
    }

    @Override
    public List<Task> saveTasks(List<Task> listTasks) {
        return taskRepository.saveAll(listTasks);
    }

    @Override
    public Task updateById(Task request, Long id) {

        if (!taskRepository.existsById(id))
            throw new UserNotFoundException("Task not found with id: " + id);

        Task aux = taskRepository.findById(id).get();


        aux.setTitle(request.getTitle());
        aux.setDescription(request.getDescription());
//        aux.setUser(request.getUser());
        aux.setStartDate(request.getStartDate());
        aux.setEndDate(request.getEndDate());
        taskRepository.save(aux);
        return aux;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    //Methods
//    @Override
//    public List<Task> findByUserAndStartDateBetween(User user, LocalDate startDate, LocalDate endDate) {
//        return taskRepository.findByUserAndStartDateBetween(user, startDate, endDate);
//
//    }
}
