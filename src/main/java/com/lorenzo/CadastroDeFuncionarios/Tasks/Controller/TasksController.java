package com.lorenzo.CadastroDeFuncionarios.Tasks.Controller;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Service.TasksService;
import com.lorenzo.CadastroDeFuncionarios.Tasks.dto.TasksDTO;
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
    public TasksDTO addTasks(@RequestBody TasksDTO dto) {
        return tasksService.addTasks(dto);
    }

    @GetMapping
    public List<TasksModel> showAllTasks() {
        return tasksService.showAllTasks();
    }

    @GetMapping("/{id}")
    public TasksModel showTasksById(@PathVariable Long id) {
        return tasksService.showTaskById(id);
    }

    @PutMapping("/{id}")
    public TasksModel updateTask(@RequestBody TasksModel tasksModel, @PathVariable Long id) {
        return tasksService.updateTask(tasksModel, id);
    }

    @DeleteMapping("/{id}")
    public void removeTask(@PathVariable Long id) {
        tasksService.removeTask(id);
    }
}
