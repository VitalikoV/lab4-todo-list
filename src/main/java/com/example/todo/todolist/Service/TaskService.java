package com.example.todo.todolist.Service;

import com.example.todo.todolist.Model.Task;
import com.example.todo.todolist.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Task> loadAllTasks(){
        return taskRepository.findAll();
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks(){
        taskRepository.deleteAll();
    }
    
    public Optional<Task> loadTask(int id){
       return taskRepository.findById(id);
    }

    }
