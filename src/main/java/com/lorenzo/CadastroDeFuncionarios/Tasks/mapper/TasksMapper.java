package com.lorenzo.CadastroDeFuncionarios.Tasks.mapper;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.dto.TasksDTO;
import org.springframework.stereotype.Component;

@Component
public class TasksMapper {

    public TasksDTO toDTO(TasksModel entity) {
        TasksDTO dto = new TasksDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setDescription(entity.getDescription());
        dto.setEmployees(entity.getEmployees());
        return dto;
    }

    public TasksModel toEntity(TasksDTO dto) {
        TasksModel entity = new TasksModel();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        entity.setDescription(dto.getDescription());
        entity.setEmployees(dto.getEmployees());
        return entity;
    }
}
