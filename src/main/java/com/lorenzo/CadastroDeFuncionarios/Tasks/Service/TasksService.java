package com.lorenzo.CadastroDeFuncionarios.Tasks.Service;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<TasksModel> showAllTasks() {
        return tasksRepository.findAll();
    }

    public TasksModel showTaskById(Long id) {
        Optional<TasksModel> optionalTasksModelShowById = tasksRepository.findById(id);
        return optionalTasksModelShowById.orElse(null);
    }
}
