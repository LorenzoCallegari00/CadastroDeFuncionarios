package com.lorenzo.CadastroDeFuncionarios.Tasks.Controller;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Service.TasksService;
import com.lorenzo.CadastroDeFuncionarios.Tasks.dto.TasksDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Cria uma nova Tarefa", description = "Rota cria nova Tarefa e insere no Banco de Dados")
    @ApiResponse(responseCode = "201", description = "Tarefa Criada com Sucesso")
    @ApiResponse(responseCode = "400", description = "Erro ao Criar Tarefa")
    public ResponseEntity<String> addTasks(@Parameter(description = "Usuario envia os dados da Tarefa a ser criada no corpo da requisicao") @RequestBody TasksDTO dto) {
        TasksDTO taskDTO = tasksService.addTasks(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa: " + taskDTO.getName() + " criada com sucesso | ID: " + taskDTO.getId());
    }

    @GetMapping
    @Operation(summary = "Mostra todas as Tarefas cadastrados", description = "Rota mostra todas as Tarefas salvas no Banco de Dados")
    @ApiResponse(responseCode = "200", description = "Mostrando tados as Tarefas")
    @ApiResponse(responseCode = "404", description = "Nao ha Tarefas Existentes")
    @ApiResponse(responseCode = "400", description = "Erro ao Mostrar Todas as Tarefas")
    public ResponseEntity<List<TasksDTO>> showAllTasks() {
        return ResponseEntity.ok(tasksService.showAllTasks());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista Tarefa pelo ID", description = "Rota Lista uma Tarefa pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Tarefa Encontrada")
    @ApiResponse(responseCode = "404", description = "Tarefa Nao Encontrada")
    public ResponseEntity<?> showTasksById(@Parameter(description = "Usuario envia o ID no Path da requisicao") @PathVariable Long id) {
        TasksDTO tasksDTO = tasksService.showTaskById(id);
        if (tasksDTO != null) {
            return ResponseEntity.ok(tasksDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa com ID: "+ id +" | Não encontrada");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza Tarefa Existente", description = "Rota atualiza Tarefa no Banco de Dados pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Tarefa Atualizada com Sucesso")
    @ApiResponse(responseCode = "404", description = "Tarefa Nao Encontrada")
    @ApiResponse(responseCode = "400", description = "Erro ao Atualizar Tarefa")
    public ResponseEntity<String> updateTask(@Parameter(description = "Usuario envia os dados da Tarefa a ser atualizada no corpo da requisicao") @RequestBody TasksDTO dto, @Parameter(description = "Usuario envia o ID no Path da requisicao") @PathVariable Long id) {
        if (tasksService.showTaskById(id) != null) {
            dto.setId(id);
            tasksService.updateTask(dto, id);
            return ResponseEntity.ok("Tarefa " + dto.getName() + " ID: " + id + " | Atualizada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa de ID: " + id + " | Não encontrada");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma Tarefa", description = "Rota remove uma Tarefa do Banco de Dados pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Tarefa Removida com Sucesso")
    @ApiResponse(responseCode = "404", description = "Tarefa Nao Encontrada")
    @ApiResponse(responseCode = "400", description = "Erro ao remover Tarefa")
    public ResponseEntity<String> removeTask(@Parameter(description = "Usuario envia o ID no Path da requisicao") @PathVariable Long id) {
        if (tasksService.showTaskById(id) != null) {
            tasksService.removeTask(id);
            return ResponseEntity.ok("Tarefa de id: " + id + " | Deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa de id: " + id + " | Não encontrada");
    }
}
