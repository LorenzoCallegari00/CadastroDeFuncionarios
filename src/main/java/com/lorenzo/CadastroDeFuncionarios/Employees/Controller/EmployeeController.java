package com.lorenzo.CadastroDeFuncionarios.Employees.Controller;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Employees.Service.EmployeesService;
import com.lorenzo.CadastroDeFuncionarios.Employees.dto.EmployeeDTO;
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
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO dto) {
        return employeesService.addEmployee(dto);
    }

    // Show all Employees (READ)
    @GetMapping
    public List<EmployeeDTO> showAllEmployees() {
        return employeesService.showAllEmployees();
    }

    // Search Employee by ID (READ)
    @GetMapping("/{id}")
    public EmployeeDTO showEmployeeById(@PathVariable Long id) {
        return employeesService.showEmployeeById(id);
    }

    // Update Employee data (UPDATE)
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO dto, @PathVariable Long id) {
        return employeesService.updateEmployee(dto, id);
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable Long id) {
        employeesService.removeEmployee(id);
    }

}
