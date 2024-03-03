package com.todo_.ToDo.List.App.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Task_")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String task_name;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String status;
}
