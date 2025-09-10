package com.lorenzo.CadastroDeFuncionarios;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private int age;

    public EmployeeModel() {
    }

    public EmployeeModel(String name, String email, String department, int age) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
