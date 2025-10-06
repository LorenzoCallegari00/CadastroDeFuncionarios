package com.lorenzo.CadastroDeFuncionarios.Tasks.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private String description;

    // A task can have many employees
    @OneToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<EmployeeModel> employees;
}
