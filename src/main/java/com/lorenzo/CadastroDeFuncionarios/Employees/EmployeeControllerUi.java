package com.lorenzo.CadastroDeFuncionarios.Employees;

import com.lorenzo.CadastroDeFuncionarios.Employees.Model.Department;
import com.lorenzo.CadastroDeFuncionarios.Employees.Model.Nivel;
import com.lorenzo.CadastroDeFuncionarios.Employees.Service.EmployeesService;
import com.lorenzo.CadastroDeFuncionarios.Employees.dto.EmployeeDTO;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Service.TasksService;
import com.lorenzo.CadastroDeFuncionarios.Tasks.Model.TasksModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/employees")
public class EmployeeControllerUi {

    private final EmployeesService employeesService;
    private final TasksService tasksService;

    public EmployeeControllerUi(EmployeesService employeesService, TasksService tasksService) {
        this.employeesService = employeesService;
        this.tasksService = tasksService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        List<EmployeeDTO> employees = employeesService.showAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/list";
    }

    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        EmployeeDTO employee = employeesService.showEmployeeById(id);
        if (employee == null) {
            return "redirect:/ui/employees?error=notfound";
        }
        model.addAttribute("employee", employee);
        return "employees/view";
    }

    @GetMapping("/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("departments", Department.values());
        model.addAttribute("niveis", Nivel.values());
        model.addAttribute("tasks", tasksService.showAllTasks());
        return "employees/form";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        EmployeeDTO employee = employeesService.showEmployeeById(id);
        if (employee == null) {
            return "redirect:/ui/employees?error=notfound";
        }
        model.addAttribute("employee", employee);
        model.addAttribute("departments", Department.values());
        model.addAttribute("niveis", Nivel.values());
        model.addAttribute("tasks", tasksService.showAllTasks());
        return "employees/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeDTO employee,
                               @RequestParam(value = "taskId", required = false) String taskIdStr) {
        // Converter taskId de String para Long e setar a tarefa
        if (taskIdStr != null && !taskIdStr.isEmpty()) {
            try {
                Long taskId = Long.parseLong(taskIdStr);
                TasksModel task = new TasksModel();
                task.setId(taskId);
                employee.setTasks(task);
            } catch (NumberFormatException e) {
                employee.setTasks(null);
            }
        } else {
            employee.setTasks(null);
        }

        if (employee.getId() == null) {
            employeesService.addEmployee(employee);
        } else {
            employeesService.updateEmployee(employee, employee.getId());
        }
        return "redirect:/ui/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeesService.removeEmployee(id);
        return "redirect:/ui/employees";
    }
}