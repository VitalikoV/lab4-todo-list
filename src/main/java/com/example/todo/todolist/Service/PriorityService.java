package com.example.todo.todolist.Service;

import com.example.todo.todolist.Model.Priority;
import com.example.todo.todolist.Repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PriorityService {

    @Autowired
    private PriorityRepository priorityRepository;

    public Iterable<Priority> loadAllPriorities(){
        return priorityRepository.findAll();
    }

    public void savePriority(Priority priority){
        priorityRepository.save(priority);
    }

    public void deleteTask(int id){
        priorityRepository.deleteById(id);
    }

    public void deleteAllPriorities(){
        priorityRepository.deleteAll();
    }

    public Optional<Priority> loadPriority(int id){
        return priorityRepository.findById(id);
    }
}
