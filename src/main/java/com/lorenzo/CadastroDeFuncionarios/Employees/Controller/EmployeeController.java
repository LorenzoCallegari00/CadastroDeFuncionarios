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
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeesService.addEmployee(employeeModel);
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
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employeeModel, @PathVariable Long id) {
        return employeesService.updateEmployee(employeeModel, id);
    }

    // Delete Employee (DELETE)
    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable Long id) {
        employeesService.removeEmployee(id);
    }

}
