package com.lorenzo.CadastroDeFuncionarios.Employees.Controller;

import com.lorenzo.CadastroDeFuncionarios.Employees.Service.EmployeesService;
import com.lorenzo.CadastroDeFuncionarios.Employees.dto.EmployeeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeesService employeesService;

    public EmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    // Add Employee (CREATE)
    @PostMapping
    @Operation(summary = "Cria um novo Funcionario", description = "Rota cria novo Funcionario e insere no Banco de Dados")
    @ApiResponse(responseCode = "201", description = "Funcionario Criado com Sucesso")
    @ApiResponse(responseCode = "400", description = "Erro ao Criar Funcionario")
    public ResponseEntity<String> addEmployee(@Parameter(description = "Usuario envia os dados do Funcionario a ser criado no corpo da requisicao") @RequestBody EmployeeDTO dto) {
        EmployeeDTO add = employeesService.addEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario: " + add.getName() + " criado com sucesso | ID: " + add.getId());
    }

    // Show all Employees (READ)
    @GetMapping
    @Operation(summary = "Mostra todos os Funcionarios cadastrados", description = "Rota mostra todos os Funcionarios salvos no Banco de Dados")
    @ApiResponse(responseCode = "200", description = "Mostrando todos os Funcionarios")
    @ApiResponse(responseCode = "404", description = "Nao ha Funcionarios Existentes")
    @ApiResponse(responseCode = "400", description = "Erro ao Mostrar Todos os Funcionarios")
    public ResponseEntity<List<EmployeeDTO>> showAllEmployees() {
        List<EmployeeDTO> employeeDTOList = employeesService.showAllEmployees();
        return ResponseEntity.ok(employeeDTOList);
    }

    // Search Employee by ID (READ)
    @GetMapping("/{id}")
    @Operation(summary = "Lista Funcionario pelo ID", description = "Rota Lista um Funcionario pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Funcionario Encontrado")
    @ApiResponse(responseCode = "404", description = "Funcionario Nao Encontrado")
    public ResponseEntity<?> showEmployeeById(@Parameter(description = "Usuario envia o ID no Path da requisicao") @PathVariable Long id) {
        EmployeeDTO findId = employeesService.showEmployeeById(id);
        if (findId != null) {
            return ResponseEntity.ok(findId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario com ID: "+ id +" | Não encontrado");
    }

    // Update Employee data (UPDATE)
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza Funcionario Existente", description = "Rota atualiza Funcionario no Banco de Dados pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Funcionario Atualizado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Funcionario Nao Encontrado")
    @ApiResponse(responseCode = "400", description = "Erro ao Atualizar Funcionario")
    public ResponseEntity<String> updateEmployee(@Parameter(description = "Usuario envia os dados do Funcionario a ser atualizado no corpo da requisicao") @RequestBody EmployeeDTO dto, @Parameter(description = "Usuario envia o ID no Path da requisicao") @PathVariable Long id) {
        if (employeesService.showEmployeeById(id) != null) {
            employeesService.updateEmployee(dto, id);
            return ResponseEntity.ok("Funcionario " + dto.getName() + " ID: " + id + " | Atualizado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario de ID: " + id + " | Não encontrado");
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um Funcionario", description = "Rota remove um Funcionario do Banco de Dados pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Funcionario Removido com Sucesso")
    @ApiResponse(responseCode = "404", description = "Funcionario Nao Encontrado")
    @ApiResponse(responseCode = "400", description = "Erro ao remover Funcionario")
    public ResponseEntity<String> removeEmployee(@Parameter(description = "Usuario envia o ID no Path da requisicao") @PathVariable Long id) {
        if (employeesService.showEmployeeById(id) != null) {
            employeesService.removeEmployee(id);
            return ResponseEntity.ok("Funcionario de id: " + id + " | Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario de id: " + id + " | Não encontrado");
    }

}
