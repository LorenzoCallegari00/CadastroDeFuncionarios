package com.lorenzo.CadastroDeFuncionarios.Employees.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Add Employee (CREATE)
    @PostMapping("/add")
    public String addEmployee() {
        return "Funcionario adicionado";
    }

    // Show all Employees (READ)
    @GetMapping("/showAll")
    public String showAllEmployees() {
        return "Listando todos os funcionarios";
    }

    // Search Employee by ID (READ)
    @GetMapping("/showById")
    public String showEmployeeById() {
        return "Mostrando funcionario de Id: ";
    }
    // Update Employee data (UPDATE)
    @PutMapping("/update")
    public String updateEmployeeById() {
        return "Funcionario de Id: atualizado";
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/delete")
    public String deleteEmployee() {
        return "Funcionario deletado";
    }

}
