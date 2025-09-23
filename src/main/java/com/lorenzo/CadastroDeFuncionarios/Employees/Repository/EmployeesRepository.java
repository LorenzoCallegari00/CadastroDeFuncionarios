package com.lorenzo.CadastroDeFuncionarios.Employees.Repository;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeeModel, Long> {}
