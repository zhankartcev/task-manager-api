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
}
