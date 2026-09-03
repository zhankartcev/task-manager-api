package com.zhankartsev.taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Этот метод автоматически поставит время перед сохранением в базу
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
