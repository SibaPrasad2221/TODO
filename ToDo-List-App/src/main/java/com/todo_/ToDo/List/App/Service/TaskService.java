package com.todo_.ToDo.List.App.Service;


import com.todo_.ToDo.List.App.Entity.Task;
import com.todo_.ToDo.List.App.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> getAllTask(){
        return taskRepo.findAll();
    }

    public void saveTask(Task t){
        taskRepo.save(t);
    }

    public Task getTaskByID(Integer id){
        Optional<Task> tasks = taskRepo.findById(id);
        Task task;

        if(tasks.isPresent()){
            task = tasks.get();
        }else{
            throw new RuntimeException("Task Not found with id: "+id);
        }
        return task;
    }

    public void deleteTask(Integer id){
        taskRepo.deleteById(id);
    }
}
