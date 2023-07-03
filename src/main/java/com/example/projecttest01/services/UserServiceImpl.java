package com.example.projecttest01.services;

import com.example.projecttest01.exception.EmailAlreadyExistsException;
import com.example.projecttest01.exception.EmailNonExistsException;
import com.example.projecttest01.exception.UserNotFoundException;
import com.example.projecttest01.models.User;
import com.example.projecttest01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;



    @Override
    public User save(User user) {

        if(userRepository.existsByEmail(user.getEmail()))
            throw new EmailAlreadyExistsException("Email ocupado");

        return userRepository.save(user);
    }
    public List<User> saveTasks (List<User> listUsers) {
        List<User> all = userRepository.saveAll(listUsers);
        return all;
    }
    public User updateById (User request, Long id) {

        if (!userRepository.existsById(id))
            throw new UserNotFoundException("User not found with id: " + id);

        User aux = userRepository.findById(id).get();


        aux.setName(request.getName());
        aux.setEmail(request.getEmail());
        aux.setTasks(request.getTasks());
        userRepository.save(aux);
        return aux;

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            throw new EmailNonExistsException("Email not found");
        }
        return user;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return (userRepository.existsByEmail(email)) ? true : false;
    }

    public Boolean deleteById (Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteAll () {
        try {
            userRepository.deleteAll();
            return true;
        }catch (Exception e) {
            return false;
        }
    }




}
