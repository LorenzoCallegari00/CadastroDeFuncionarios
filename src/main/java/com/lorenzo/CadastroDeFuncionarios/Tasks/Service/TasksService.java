package com.lorenzo.CadastroDeFuncionarios.Tasks.Service;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Repository.TasksRepository;
import com.lorenzo.CadastroDeFuncionarios.Tasks.dto.TasksDTO;
import com.lorenzo.CadastroDeFuncionarios.Tasks.mapper.TasksMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;
    private final TasksMapper tasksMapper;

    public TasksService(TasksRepository tasksRepository, TasksMapper tasksMapper) {
        this.tasksRepository = tasksRepository;
        this.tasksMapper = tasksMapper;
    }

    // Show All Tasks
    public List<TasksDTO> showAllTasks() {
        List<TasksModel> entity = tasksRepository.findAll();
        return entity.stream()
                .map(tasksMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Show Tasks By their ID
    public TasksDTO showTaskById(Long id) {
        Optional<TasksModel> taskById = tasksRepository.findById(id);
        return taskById.map(tasksMapper::toDTO).orElse(null);
    }

    // Add new task
    public TasksDTO addTasks(TasksDTO dto) {
        TasksModel entity = tasksMapper.toEntity(dto);
        entity = tasksRepository.save(entity);
        return tasksMapper.toDTO(entity);
    }

    // Delete Task
    public void removeTask(Long id) {
        tasksRepository.deleteById(id);
    }

     // Update Task
    public TasksDTO updateTask(TasksDTO dto, Long id) {
        Optional<TasksModel> existentTasksModel = tasksRepository.findById(id);
        if (existentTasksModel.isPresent()) {
            TasksModel entity = tasksMapper.toEntity(dto);
            entity.setId(id);
            TasksModel saved = tasksRepository.save(entity);
            return tasksMapper.toDTO(saved);
        }
        return null;
    }

}
