package com.example.Task_311.services;

import com.example.Task_311.model.User;
import com.example.Task_311.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public User findOne(long id){
        Optional<User> user = usersRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public void saveUser(User user){
        usersRepository.save(user);
    }

    @Transactional
    public void updateUser(long id, User user){
        user.setId(id);
        usersRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id){
        usersRepository.deleteById(id);
    }
}
