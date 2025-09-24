package com.lorenzo.CadastroDeFuncionarios.Tasks.Service;

import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<TasksModel> showAllTasks() {
        return tasksRepository.findAll();
    }
}
