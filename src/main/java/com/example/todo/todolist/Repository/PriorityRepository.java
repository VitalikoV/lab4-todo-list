package com.example.todo.todolist.Repository;

import com.example.todo.todolist.Model.Priority;
import com.example.todo.todolist.Model.Task;
import com.example.todo.todolist.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PriorityRepository extends CrudRepository<Priority, Integer> {
    @Override
    Iterable<Priority> findAll();

    @Override
    Optional<Priority> findById(Integer integer);
}
