package by.training.employeemanager.web;

import by.training.employeemanager.entity.Employee;
import by.training.employeemanager.entity.Vacation;
import by.training.employeemanager.repository.EmployeeRepository;
import by.training.employeemanager.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vacation")
public class VacationController {
    private VacationRepository vacationRepository;
    private EmployeeRepository employeeRepository;


    public VacationController() {
    }

    @Autowired
    public VacationController(VacationRepository vacationRepository, EmployeeRepository employeeRepository) {
        this.vacationRepository = vacationRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    @ResponseBody
    Iterable<Vacation> getAll() {
        return vacationRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Vacation getVacation(@PathVariable Long id) {
        return vacationRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ResponseBody
    void postVacation(@RequestBody Vacation vacation) {
        vacationRepository.save(vacation);
    }

    @PostMapping("/byName/{employee},{owner}")
    @ResponseBody
    void postVacationbyNames(@PathVariable String employee, @PathVariable String owner, @RequestBody Vacation vacation) {
        Employee requester = employeeRepository.findEmployeeByName(employee);
        Employee approvedBy = employeeRepository.findEmployeeByName(owner);
        vacation.setEmployeeID(requester.getId());
        vacation.setApprovedBy(approvedBy.getId());
        vacationRepository.save(vacation);
    }

    @PutMapping("/")
    @ResponseBody
    void updateVacaion(@RequestBody Vacation vacation) {
        Vacation oldVacation = vacationRepository.findById(vacation.getId()).orElse(null);
        if (oldVacation != null) {
            oldVacation.setEmployeeID(vacation.getEmployeeID());
            oldVacation.setDateFrom(vacation.getDateFrom());
            oldVacation.setDateTo(vacation.getDateTo());
            oldVacation.setApprovedBy(vacation.getApprovedBy());
            vacationRepository.save(oldVacation);
        } else {
            vacationRepository.save(vacation);
        }
    }
}
