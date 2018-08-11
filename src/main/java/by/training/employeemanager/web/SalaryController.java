package by.training.employeemanager.web;

import by.training.employeemanager.model.SalaryResult;
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
@RequestMapping("/api/salary")
public class SalaryController {
    private NamedParameterJdbcTemplate template;

    private final static String EMPLOYEE_ALL_SALARYS = "SELECT EMP_NAME, PRF_SALARY, EMP_BONUS, PRF_SALARY + EMP_BONUS AS `Total` FROM EMPLOYEE JOIN PROFESSION ON EMP_PROFESSION = PRF_ID;";
    private final static String EMPLOYEE_SALARY = "SELECT EMP_NAME, PRF_SALARY, EMP_BONUS, PRF_SALARY + EMP_BONUS AS `Total` FROM EMPLOYEE JOIN PROFESSION ON EMP_PROFESSION = PRF_ID WHERE EMP_NAME = ':name';";

    @Autowired
    public SalaryController(EmployeeRepository employeeRepository, NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public SalaryController() {
    }

    @GetMapping("/{name}")
    @ResponseBody
    SalaryResult getEmploeeSalary(@PathVariable String name) {
        List<SalaryResult> salaryResults = new ArrayList<>();
        template.query(EMPLOYEE_SALARY.replace(":name", name), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                SalaryResult salaryResult = new SalaryResult(
                        rs.getString("Emp_Name"),
                        rs.getLong("Prf_Salary"),
                        rs.getLong("Emp_Bonus"),
                        rs.getLong("Total")
                );
                salaryResults.add(salaryResult);
            }
        });
        return salaryResults.get(0);
    }


    @GetMapping("/")
    @ResponseBody
    List<SalaryResult> getAllEmploeeSalary() {
        List<SalaryResult> salaryResults = new ArrayList<>();
        template.query(EMPLOYEE_ALL_SALARYS, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                SalaryResult salaryResult = new SalaryResult(
                        rs.getString("Emp_Name"),
                        rs.getLong("Prf_Salary"),
                        rs.getLong("Emp_Bonus"),
                        rs.getLong("Total")
                );
                salaryResults.add(salaryResult);
            }
        });
        return salaryResults;
    }
}