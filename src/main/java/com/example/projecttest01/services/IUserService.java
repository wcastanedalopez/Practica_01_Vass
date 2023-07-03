package com.example.projecttest01.services;

import com.example.projecttest01.models.User;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;


public interface IUserService {

    User save(User user);
    public List<User> saveTasks (List<User> listUsers);
    List<User> findAll();
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    public Boolean deleteById (Long id);

    public Boolean deleteAll();
    public User updateById (User request, Long id);



}
