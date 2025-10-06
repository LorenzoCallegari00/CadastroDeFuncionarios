package com.lorenzo.CadastroDeFuncionarios.Tasks.Controller;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Service.TasksService;
import com.lorenzo.CadastroDeFuncionarios.Tasks.dto.TasksDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public ResponseEntity<String> addTasks(@RequestBody TasksDTO dto) {
        TasksDTO taskDTO = tasksService.addTasks(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa: " + taskDTO.getName() + " criada com sucesso | ID: " + taskDTO.getId());
    }

    @GetMapping
    public ResponseEntity<List<TasksDTO>> showAllTasks() {
        return ResponseEntity.ok(tasksService.showAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showTasksById(@PathVariable Long id) {
        TasksDTO tasksDTO = tasksService.showTaskById(id);
        if (tasksDTO != null) {
            return ResponseEntity.ok(tasksDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa com ID: "+ id +" | Não encontrada");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@RequestBody TasksDTO dto, @PathVariable Long id) {
        if (tasksService.showTaskById(id) != null) {
            dto.setId(id);
            tasksService.updateTask(dto, id);
            return ResponseEntity.ok("Tarefa " + dto.getName() + " ID: " + id + " | Atualizada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa de ID: " + id + " | Não encontrada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTask(@PathVariable Long id) {
        if (tasksService.showTaskById(id) != null) {
            tasksService.removeTask(id);
            return ResponseEntity.ok("Tarefa de id: " + id + " | Deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa de id: " + id + " | Não encontrada");
    }
}
