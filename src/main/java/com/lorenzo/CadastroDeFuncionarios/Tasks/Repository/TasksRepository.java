package com.lorenzo.CadastroDeFuncionarios.Tasks.Repository;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TasksModel, Long> {}
