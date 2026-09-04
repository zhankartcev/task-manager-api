package com.zhankartsev.taskmanager.service;

import com.zhankartsev.taskmanager.entity.Task;
import com.zhankartsev.taskmanager.entity.TaskStatus;
import com.zhankartsev.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    //method : get All tasks

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    //method : create new task
    public Task createTask(Task task) {
        task.setStatus(TaskStatus.TODO);
        return taskRepository.save(task);
    }

    // method : update task

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Задача с ID " + id + " не найдена"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());

        return taskRepository.save(task);

    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
