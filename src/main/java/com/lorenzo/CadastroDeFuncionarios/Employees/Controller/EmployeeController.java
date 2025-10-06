package com.lorenzo.CadastroDeFuncionarios.Employees.Controller;

import com.lorenzo.CadastroDeFuncionarios.Employees.Service.EmployeesService;
import com.lorenzo.CadastroDeFuncionarios.Employees.dto.EmployeeDTO;
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
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO dto) {
        EmployeeDTO add = employeesService.addEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario: " + add.getName() + " criado com sucesso | ID: " + add.getId());
    }

    // Show all Employees (READ)
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> showAllEmployees() {
        return ResponseEntity.ok(employeesService.showAllEmployees());
    }

    // Search Employee by ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<?> showEmployeeById(@PathVariable Long id) {
        EmployeeDTO findId = employeesService.showEmployeeById(id);
        if (findId != null) {
            return ResponseEntity.ok(findId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario com ID: "+ id +" | Não encontrado");
    }

    // Update Employee data (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO dto, @PathVariable Long id) {
        if (employeesService.showEmployeeById(id) != null) {
            employeesService.updateEmployee(dto, id);
            return ResponseEntity.ok("Funcionario " + dto.getName() + " ID: " + id + " | Atualizado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario de ID: " + id + " | Não encontrado");
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Long id) {
        if (employeesService.showEmployeeById(id) != null) {
            employeesService.removeEmployee(id);
            return ResponseEntity.ok("Funcionario de id: " + id + " | Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario de id: " + id + " | Não encontrado");
    }

}
