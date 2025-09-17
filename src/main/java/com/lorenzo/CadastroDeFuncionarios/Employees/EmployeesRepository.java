package com.lorenzo.CadastroDeFuncionarios.Employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeeModel, Long> {
}
