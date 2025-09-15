package com.lorenzo.CadastroDeFuncionarios.Employees;

import com.lorenzo.CadastroDeFuncionarios.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private Department department;
    private int age;

    // Many employees have only one task.
    @ManyToOne
    @JoinColumn(name = "tasks_id") // Foreign Key
    private TasksModel tasks;
}
