package com.lorenzo.CadastroDeFuncionarios.Employees.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployeeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Add Employee (CREATE)
    @PostMapping("/addEmployee")
    public String addEmployee() {
        return "Funcionario adicionado";
    }

    // Show all Employees (READ)
    @GetMapping("/showAllEmployees")
    public String showAllEmployees() {
        return "Listando todos os funcionarios";
    }

    // Search Employee by ID (READ)
    @GetMapping("/showEmployeeById")
    public String showEmployeeById() {
        return "Mostrando funcionario de Id: ";
    }
    // Update Employee data (UPDATE)
    @PutMapping("/updateEmployeeById")
    public String updateEmployeeById() {
        return "Funcionario de Id: atualizado";
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/deleteEmployeeById")
    public String deleteEmployee() {
        return "Funcionario deletado";
    }

}
