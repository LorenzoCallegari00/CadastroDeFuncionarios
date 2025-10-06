package com.lorenzo.CadastroDeFuncionarios.Employees.Service;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Employees.Repository.EmployeesRepository;
import com.lorenzo.CadastroDeFuncionarios.Employees.dto.EmployeeDTO;
import com.lorenzo.CadastroDeFuncionarios.Employees.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeesService(EmployeesRepository employeesRepository, EmployeeMapper employeeMapper) {
        this.employeesRepository = employeesRepository;
        this.employeeMapper = employeeMapper;
    }

    // Show All Employees
    public List<EmployeeDTO> showAllEmployees() {
        List<EmployeeModel> employeeModelList = employeesRepository.findAll();
        return employeeModelList.stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Show Employees By their ID
    public EmployeeDTO showEmployeeById(Long id) {
        Optional<EmployeeModel> employeeById = employeesRepository.findById(id);
        return employeeById.map(employeeMapper::toDTO).orElse(null);
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
    public EmployeeDTO updateEmployee(EmployeeDTO dto, Long id) {
        Optional<EmployeeModel> existentEmployee = employeesRepository.findById(id);
        if (existentEmployee.isPresent()) {
            EmployeeModel entity = employeeMapper.toEntity(dto);
            entity.setId(id);
            EmployeeModel saved = employeesRepository.save(entity);
            return employeeMapper.toDTO(saved);
        }
        return null;
    }

}
