package com.example.todo.todolist.Repository;

import com.example.todo.todolist.Model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    @Override
    Iterable<Task> findAll();
}
