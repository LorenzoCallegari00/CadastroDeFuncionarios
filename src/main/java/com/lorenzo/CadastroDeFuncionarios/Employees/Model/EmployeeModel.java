package com.lorenzo.CadastroDeFuncionarios.Employees.Model;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_registration")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "tasks")
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

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    // Many employees have only one task.
    @ManyToOne
    @JoinColumn(name = "tasks_id") // Foreign Key
    private TasksModel tasks;
}

