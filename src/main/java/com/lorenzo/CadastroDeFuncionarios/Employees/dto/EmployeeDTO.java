package com.lorenzo.CadastroDeFuncionarios.Employees.dto;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.Department;
import com.lorenzo.CadastroDeFuncionarios.Employees.Model.Nivel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private Department department;
    private int age;
    private String imgUrl;
    private String email;
    private TasksModel tasks;
    private Nivel nivel;

}