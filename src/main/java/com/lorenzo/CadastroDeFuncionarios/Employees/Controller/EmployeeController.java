package com.lorenzo.CadastroDeFuncionarios.Employees.Controller;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Employees.Service.EmployeesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeesService employeesService;

    public EmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Add Employee (CREATE)
    @PostMapping
    public String addEmployee() {
        return "Funcionario adicionado";
    }

    // Show all Employees (READ)
    @GetMapping
    public List<EmployeeModel> showAllEmployees() {
        return employeesService.showAllEmployees();
    }

    // Search Employee by ID (READ)
    @GetMapping("/{id}")
    public EmployeeModel showEmployeeById(@PathVariable Long id) {
        return employeesService.showEmployeeById(id);
    }
    // Update Employee data (UPDATE)
    @PutMapping("/{id}")
    public String updateEmployeeById() {
        return "Funcionario de Id: atualizado";
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    public String deleteEmployee() {
        return "Funcionario deletado";
    }

}
