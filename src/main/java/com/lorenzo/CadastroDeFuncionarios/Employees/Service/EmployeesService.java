package com.lorenzo.CadastroDeFuncionarios.Employees.Service;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Employees.Repository.EmployeesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    private EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    // Show All Employees
    public List<EmployeeModel> showAllEmployees() {
        return employeesRepository.findAll();
    }

    // Show Employees By their ID
    public EmployeeModel showEmployeeById(Long id) {
        Optional<EmployeeModel> optionalEmployeeModelShowById = employeesRepository.findById(id);
        return optionalEmployeeModelShowById.orElse(null);
    }

    // Add new Employee
    public EmployeeModel addEmployee (EmployeeModel employeeModel) {
        return employeesRepository.save(employeeModel);
    }

    // Delete Employee
    public void removeEmployee(Long id) {
        employeesRepository.deleteById(id);
    }

    // Update Employee
    public EmployeeModel updateEmployee(EmployeeModel employeeModel, Long id) {
        if (employeesRepository.existsById(id)) {
            employeeModel.setId(id);
            return employeesRepository.save(employeeModel);
        }
        return null;
    }

}
