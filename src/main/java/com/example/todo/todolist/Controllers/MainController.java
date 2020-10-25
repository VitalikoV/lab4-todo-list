package com.example.todo.todolist.Controllers;

import com.example.todo.todolist.ImportanceValues;
import com.example.todo.todolist.Model.Task;
import com.example.todo.todolist.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class MainController {

    public static final String REDIRECT_TO_GENERAL_PAGE = "redirect:/tasks";
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String main(Model model) {
//        Iterable<Task> tasks = taskService.loadAllTasks();
//        model.addAttribute("tasks", tasks);
//        model.addAttribute("importanceValues", List.of("important", "normal"));
        return "hello";
    }

    //    Show all tasks
    @GetMapping("/tasks")
    public String mainTasks(Model model) {
        Iterable<Task> tasks = taskService.loadAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("importanceValues", List.of("important", "normal"));
        return "main";
    }

    //    Creating and adding to database new task
    @PostMapping("/tasks")
    public String createPost(@RequestParam("name") String name, @RequestParam("description") String description,
                             @RequestParam("startTime") Time startTime, @RequestParam("endTime") Time endTime, @RequestParam("importance") String importance) {
        Task task = new Task(name, description, startTime, endTime, importance);
        taskService.saveTask(task);
        return REDIRECT_TO_GENERAL_PAGE;
    }

    //    In order to show one task with specified id
    @GetMapping("/tasks/{id}")
    public String showTask(@PathVariable(value = "id") int id, Model model) {
        Optional<Task> task = taskService.loadTask(id);
        model.addAttribute("task", task);
        return "task";
    }

    //    Show template for editing and loading data from database about this task
    @GetMapping("tasks/{id}/edit")
    public String getupdateTask(@PathVariable int id, Model model) {
        Optional<Task> task = taskService.loadTask(id);
        model.addAttribute("task", task);
        model.addAttribute("importanceValues", List.of("important", "normal"));
//        model.addAttribute("importanceValues", ImportanceValues.values());

        return "task-edit";
    }

    //    Change task
    @PostMapping("tasks/{id}/edit")
    public String postUpdateTask(@PathVariable int id, @RequestParam("name") String name, @RequestParam("description") String description,
                                 @RequestParam("startTime") Time startTime, @RequestParam("endTime") Time endTime, @RequestParam("importance") String importance) {
        Task task = taskService.loadTask(id).orElseThrow();
        Task task2 = new Task(task.getName(), task.getDescription(), task.getStartTime(), task.getEndTime(), task.getImportance());
        taskService.deleteTask(id);
        task2.setId(id);
        task2.setName(name);
        task2.setDescription(description);
        task2.setStartTime(startTime);
        task2.setEndTime(endTime);
        task2.setImportance(importance);
        taskService.saveTask(task2);
        return REDIRECT_TO_GENERAL_PAGE;
    }

    //    Delete task
    @GetMapping("tasks/{id}/delete")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return REDIRECT_TO_GENERAL_PAGE;
    }

    //    Transfer to immediate section
    @GetMapping("tasks/{id}/immediate")
    public String transferToImmediate(@PathVariable int id) {
        Task task = taskService.loadTask(id).orElseThrow();
        task.setImportance("important");
        taskService.saveTask(task);
        return REDIRECT_TO_GENERAL_PAGE;
    }

    //    Transfer to normal section
    @GetMapping("tasks/{id}/normal")
    public String transferToNormal(@PathVariable int id) {
        Task task = taskService.loadTask(id).orElseThrow();
        task.setImportance("normal");
        taskService.saveTask(task);
        return REDIRECT_TO_GENERAL_PAGE;
    }

    //    Transfer to done section
    @GetMapping("tasks/{id}/done")
    public String transferToDone(@PathVariable int id) {
        Task task = taskService.loadTask(id).orElseThrow();
        task.setImportance("done");
        taskService.saveTask(task);
        return REDIRECT_TO_GENERAL_PAGE;
    }

}
