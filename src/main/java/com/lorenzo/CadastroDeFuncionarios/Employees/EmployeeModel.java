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
    @Enumerated(EnumType.STRING)
    private Department department;
    private int age;
    private String imgUrl;

    @Column(unique = true)
    private String email;

    // Many employees have only one task.
    @ManyToOne
    @JoinColumn(name = "tasks_id") // Foreign Key
    private TasksModel tasks;
}
