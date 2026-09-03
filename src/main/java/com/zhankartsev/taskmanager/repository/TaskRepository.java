package com.zhankartsev.taskmanager.repository;

import com.zhankartsev.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //JpaRepository уже содержит методы save(), findAll(), findById() и т.д.

}
