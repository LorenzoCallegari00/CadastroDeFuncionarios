package com.lorenzo.CadastroDeFuncionarios.Employees.Service;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Employees.Repository.EmployeesRepository;
import com.lorenzo.CadastroDeFuncionarios.Employees.dto.EmployeeDTO;
import com.lorenzo.CadastroDeFuncionarios.Employees.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    private EmployeesRepository employeesRepository;
    private EmployeeMapper employeeMapper;

    public EmployeesService(EmployeesRepository employeesRepository, EmployeeMapper employeeMapper) {
        this.employeesRepository = employeesRepository;
        this.employeeMapper = employeeMapper;
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
    public EmployeeDTO addEmployee (EmployeeDTO dto) {
        EmployeeModel entity = employeeMapper.toEntity(dto);
        entity = employeesRepository.save(entity);
        return employeeMapper.toDTO(entity);

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
