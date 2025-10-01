package com.lorenzo.CadastroDeFuncionarios.Employees.mapper;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Employees.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDTO (EmployeeModel entity) {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(entity.getId());
        employeeDTO.setName(entity.getName());
        employeeDTO.setDepartment(entity.getDepartment());
        employeeDTO.setAge(entity.getAge());
        employeeDTO.setImgUrl(entity.getImgUrl());
        employeeDTO.setEmail(entity.getEmail());
        employeeDTO.setTasks(entity.getTasks());
        employeeDTO.setNivel(entity.getNivel());

        return employeeDTO;
    }

    public EmployeeModel toEntity(EmployeeDTO dto) {

        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setId(dto.getId());
        employeeModel.setName(dto.getName());
        employeeModel.setDepartment(dto.getDepartment());
        employeeModel.setAge(dto.getAge());
        employeeModel.setImgUrl(dto.getImgUrl());
        employeeModel.setEmail(dto.getEmail());
        employeeModel.setTasks(dto.getTasks());
        employeeModel.setNivel(dto.getNivel());

        return employeeModel;
    }
}
