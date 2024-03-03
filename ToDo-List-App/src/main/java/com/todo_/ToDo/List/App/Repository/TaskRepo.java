package com.todo_.ToDo.List.App.Repository;

import com.todo_.ToDo.List.App.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
