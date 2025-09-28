package com.lorenzo.CadastroDeFuncionarios.Tasks.Service;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Repository.TasksRepository;
import com.lorenzo.CadastroDeFuncionarios.Tasks.dto.TasksDTO;
import com.lorenzo.CadastroDeFuncionarios.Tasks.mapper.TasksMapper;
import org.hibernate.query.sqm.mutation.internal.TableKeyExpressionCollector;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private TasksRepository tasksRepository;
    private TasksMapper tasksMapper;

    public TasksService(TasksRepository tasksRepository, TasksMapper tasksMapper) {
        this.tasksRepository = tasksRepository;
        this.tasksMapper = tasksMapper;
    }

    // Show All Tasks
    public List<TasksModel> showAllTasks() {
        return tasksRepository.findAll();
    }

    // Show Tasks By their ID
    public TasksModel showTaskById(Long id) {
        Optional<TasksModel> optionalTasksModelShowById = tasksRepository.findById(id);
        return optionalTasksModelShowById.orElse(null);
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
    public TasksModel updateTask(TasksModel tasksModel, Long id) {
         if (tasksRepository.existsById(id)) {
             tasksModel.setId(id);
             return tasksRepository.save(tasksModel);
         }

         return null;
    }

}
