package com.example.todo.todolist.Repository;

import com.example.todo.todolist.Model.Priority;
import com.example.todo.todolist.Model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    @Override
    Iterable<Task> findAll();

    @Override
    Optional<Task> findById(Integer integer);
}
