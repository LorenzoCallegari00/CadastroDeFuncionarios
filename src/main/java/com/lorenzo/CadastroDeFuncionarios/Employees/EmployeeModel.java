package com.lorenzo.CadastroDeFuncionarios.Employees;

import com.lorenzo.CadastroDeFuncionarios.Tasks.TasksModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_registration")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Department department;
    private int age;

    // Many employees have only one task.
    @ManyToOne
    @JoinColumn(name = "tasks_id") // Foreign Key
    private TasksModel tasks;

    public EmployeeModel() {
    }

    public EmployeeModel(String name, String email, Department department, int age) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.age = age;
    }

    public Long getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Department getDepartment() {return department;}

    public void setDepartment(Department department) {this.department = department;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}
}
