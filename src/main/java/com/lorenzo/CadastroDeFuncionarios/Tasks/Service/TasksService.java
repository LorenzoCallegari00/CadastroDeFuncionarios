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
    public TasksModel addTasks(TasksModel tasksModel) {
        return tasksRepository.save(tasksModel);
    }


    // Delete Task
    public void removeTask(Long id) {
        tasksRepository.deleteById(id);
    }

}
