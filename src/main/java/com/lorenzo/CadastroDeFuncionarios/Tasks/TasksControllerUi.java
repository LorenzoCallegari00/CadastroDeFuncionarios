package com.lorenzo.CadastroDeFuncionarios.Tasks;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TaskStatus;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Service.TasksService;
import com.lorenzo.CadastroDeFuncionarios.Tasks.dto.TasksDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/tasks")
public class TasksControllerUi {

    private final TasksService tasksService;

    public TasksControllerUi(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public String listTasks(Model model) {
        List<TasksDTO> tasks = tasksService.showAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks/list";
    }

    @GetMapping("/{id}")
    public String viewTask(@PathVariable Long id, Model model) {
        TasksDTO task = tasksService.showTaskById(id);
        if (task == null) {
            return "redirect:/ui/tasks?error=notfound";
        }
        model.addAttribute("task", task);
        return "tasks/view";
    }

    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new TasksDTO());
        model.addAttribute("statuses", TaskStatus.values());
        return "tasks/form";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        TasksDTO task = tasksService.showTaskById(id);
        if (task == null) {
            return "redirect:/ui/tasks?error=notfound";
        }
        model.addAttribute("task", task);
        model.addAttribute("statuses", TaskStatus.values());
        return "tasks/form";
    }

    @PostMapping("/save")
    public String saveTask(@RequestParam(value = "id", required = false) String idStr,
                           @RequestParam("name") String name,
                           @RequestParam("status") TaskStatus status,
                           @RequestParam("description") String description) {
        TasksDTO task = new TasksDTO();

        // Converter ID
        if (idStr != null && !idStr.isEmpty() && !idStr.equals("0")) {
            try {
                Long id = Long.parseLong(idStr);
                task.setId(id);
                // Buscar tarefa existente para preservar employees
                TasksDTO existing = tasksService.showTaskById(id);
                if (existing != null) {
                    task.setEmployees(existing.getEmployees());
                }
            } catch (NumberFormatException e) {
                task.setId(null);
            }
        }

        task.setName(name);
        task.setStatus(status);
        task.setDescription(description);

        if (task.getId() == null) {
            tasksService.addTasks(task);
        } else {
            tasksService.updateTask(task, task.getId());
        }
        return "redirect:/ui/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        try {
            // Verificar se a tarefa existe e tem funcionários
            TasksDTO task = tasksService.showTaskById(id);
            if (task != null && task.getEmployees() != null && !task.getEmployees().isEmpty()) {
                // Redirecionar com erro se houver funcionários associados
                return "redirect:/ui/tasks?error=hasemployees";
            }
            tasksService.removeTask(id);
            return "redirect:/ui/tasks";
        } catch (Exception e) {
            return "redirect:/ui/tasks?error=delete";
        }
    }
}