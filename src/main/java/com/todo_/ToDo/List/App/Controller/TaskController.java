package com.todo_.ToDo.List.App.Controller;


import com.todo_.ToDo.List.App.Entity.Task;
import com.todo_.ToDo.List.App.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

//@RestController
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("allTaskList", taskService.getAllTask());
        return "index";
    }

    @GetMapping("/addNew")
    public String addTask(Model model){
        Task task = new Task();
//        Date mydate = new Date("12/31/2024");
//        task.setDate(mydate);
//        task.setStatus("joined");
        model.addAttribute("task", task);
        return "newTask";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.saveTask(task);
        return "redirect:/";
    }

    @GetMapping("/showFormToUpdate/{id}")
    public String updateTask(@PathVariable("id") Integer id, Model model){
        Task task = taskService.getTaskByID(id);
        model.addAttribute("task", task);
        return "update";
    }


    @GetMapping("deleteTask/{id}")
    public String deleteByID(@PathVariable("id") Integer id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
