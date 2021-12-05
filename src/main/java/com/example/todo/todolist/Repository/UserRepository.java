package com.example.todo.todolist.Repository;

import com.example.todo.todolist.Model.Task;
import com.example.todo.todolist.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    Iterable<User> findAll();

    @Override
    Optional<User> findById(Integer integer);
}