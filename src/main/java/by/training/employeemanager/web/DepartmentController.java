package by.training.employeemanager.web;

import by.training.employeemanager.entity.Department;
import by.training.employeemanager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentRepository departmentRepository;

    public DepartmentController() {
    }

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/")
    @ResponseBody
    Iterable<Department> getAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Department getDepartment(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ResponseBody
    void postDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
    }
}
