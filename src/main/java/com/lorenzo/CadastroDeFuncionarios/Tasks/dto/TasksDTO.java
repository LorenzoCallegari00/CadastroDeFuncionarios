package com.lorenzo.CadastroDeFuncionarios.Tasks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksDTO {

    private Long id;
    private String name;
    private TaskStatus status;
    private String description;
    private List<EmployeeModel> employees;

}
