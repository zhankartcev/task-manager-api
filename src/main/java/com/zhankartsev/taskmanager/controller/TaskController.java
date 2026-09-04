package com.zhankartsev.taskmanager.controller;

import com.zhankartsev.taskmanager.entity.Task;
import com.zhankartsev.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor

public class TaskController {
    private final TaskService taskService;

    // GET
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    //POST
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);

    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);

    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
