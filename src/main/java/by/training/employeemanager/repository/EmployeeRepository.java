package by.training.employeemanager.repository;

import by.training.employeemanager.entity.Employee;

public interface EmployeeRepository extends EntityRepository<Employee> {
    Employee findEmployeeByName(String name);
     void deleteEmployeeByName(String name);
}