package com.lorenzo.CadastroDeFuncionarios.Tasks;

import com.lorenzo.CadastroDeFuncionarios.Employees.EmployeeModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private TaskStatus status;
    private String description;

    // A task can have many employees
    @OneToMany(mappedBy = "tasks")
    private List<EmployeeModel> employees;


}
