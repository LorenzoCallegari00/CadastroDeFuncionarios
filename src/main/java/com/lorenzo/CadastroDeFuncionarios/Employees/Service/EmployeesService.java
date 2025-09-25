package com.lorenzo.CadastroDeFuncionarios.Employees.Service;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Employees.Repository.EmployeesRepository;
import org.springframework.stereotype.Service;

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

}
