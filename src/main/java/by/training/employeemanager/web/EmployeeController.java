package by.training.employeemanager.web;

import by.training.employeemanager.entity.Employee;
import by.training.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private NamedParameterJdbcTemplate template;

    private final static String EMPLOYEE_BY_DEPARTMENT = "SELECT Emp_Id, Emp_Name, Emp_Passport_Number, Emp_Department, Emp_Profession, Emp_Bonus FROM EMPLOYEE JOIN DEPARTMENT ON DEP_ID = EMP_DEPARTMENT WHERE DEP_NAME = ':department';";

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, NamedParameterJdbcTemplate template) {
        this.employeeRepository = employeeRepository;
        this.template = template;
    }

    public EmployeeController() {
    }

    @GetMapping("/deleteById/{id}")
    @ResponseBody
    Long deleteEmploee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return id;
    }

    @GetMapping("/deleteByName/{name}")
    @ResponseBody
    String deleteByNameEmploee(@PathVariable String name) {
        System.out.println(name);
        employeeRepository.deleteEmployeeByName(name);
        return name;
    }

    @GetMapping("/")
    @ResponseBody
    Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Employee getEmploee(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("/byName/{name}")
    @ResponseBody
    Employee getEmploee(@PathVariable String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @GetMapping("/byDepartment/{department}")
    @ResponseBody
    List<Employee> getEmploeeByDepartment(@PathVariable String department) {
        List<Employee> employees = new ArrayList<>();
        template.query(EMPLOYEE_BY_DEPARTMENT.replace(":department", department), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Employee employee = new Employee(
                        rs.getLong("Emp_Id"),
                        rs.getString("Emp_Name"),
                        rs.getString("Emp_Passport_Number"),
                        rs.getLong("Emp_Department"),
                        rs.getLong("Emp_Profession"),
                        rs.getLong("Emp_Bonus")
                );
                employees.add(employee);
            }
        });
        return employees;
    }

    @PostMapping("/")
    @ResponseBody
    void postEmploee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PostMapping("/put/")
    @ResponseBody
    void updateEmploee(@RequestBody Employee employee) {
        Employee oldEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        if (oldEmployee != null) {
            oldEmployee.setName(employee.getName());
            oldEmployee.setPassportNumber(employee.getPassportNumber());
            oldEmployee.setDepartment(employee.getDepartment());
            oldEmployee.setProfessionId(employee.getProfessionId());
            oldEmployee.setSalaryBonus(employee.getSalaryBonus());
            employeeRepository.save(oldEmployee);
        } else {
            employeeRepository.save(employee);
        }
    }
}
