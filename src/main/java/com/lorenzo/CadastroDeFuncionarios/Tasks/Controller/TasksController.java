package com.lorenzo.CadastroDeFuncionarios.Tasks.Controller;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Service.TasksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public String addTask() {
        return "Tarefa criada com sucesso";
    }

    @GetMapping
    public List<TasksModel> showAllTasks() {
        return tasksService.showAllTasks();
    }

    @GetMapping("/{id}")
    public String showTaskById() {
        return "Mostrando tarefa de Id: ";
    }

    @PutMapping("/{id}")
    public String updateTasks() {
        return "Tarefa atualizada com sucesso";
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById() {
        return "Tarefa deletada";
    }
}
