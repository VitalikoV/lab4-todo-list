package com.example.todo.todolist.Service;

import com.example.todo.todolist.Model.Priority;
import com.example.todo.todolist.Model.User;
import com.example.todo.todolist.Repository.PriorityRepository;
import com.example.todo.todolist.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> loadAllUsers(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public Optional<User> loadUser(int id){
        return userRepository.findById(id);
    }
}
