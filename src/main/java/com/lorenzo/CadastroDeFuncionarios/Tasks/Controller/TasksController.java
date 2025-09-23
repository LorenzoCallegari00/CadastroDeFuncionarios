package com.lorenzo.CadastroDeFuncionarios.Tasks.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
public class TasksController {

    @PostMapping("/add")
    public String addTask() {
        return "Tarefa criada com sucesso";
    }

    @GetMapping("/showAll")
    public String showAllTasks() {
        return "Mostrando todas as tarefas";
    }

    @GetMapping("/showById")
    public String showTaskById() {
        return "Mostrando tarefa de Id: ";
    }

    @PutMapping("/update")
    public String updateTasks() {
        return "Tarefa atualizada com sucesso";
    }

    @DeleteMapping("/delete")
    public String deleteTaskById() {
        return "Tarefa deletada";
    }
}
