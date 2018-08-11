package by.training.employeemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Emp_Id")))
public class Employee extends AbstractEntity {

    @Column(name = "Emp_Name")
    private String name;

    @Column(name = "Emp_Passport_Number")
    private String passportNumber;

    @Column(name = "Emp_Department")
    private Long department;

    @Column(name = "Emp_Profession")
    private Long professionId;

    @Column(name = "Emp_Bonus")
    private Long salaryBonus;

    public Employee() {
    }

    public Employee(Long id, String name, String passportNumber, Long department, Long professionId, Long salaryBonus) {
        super(id);
        this.name = name;
        this.passportNumber = passportNumber;
        this.department = department;
        this.professionId = professionId;
        this.salaryBonus = salaryBonus;
    }

    public Employee(String name, String passportNumber, Long department, Long professionId, Long salaryBonus) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.department = department;
        this.professionId = professionId;
        this.salaryBonus = salaryBonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public Long getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(Long salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", department=" + department +
                ", professionId=" + professionId +
                ", salaryBonus=" + salaryBonus +
                '}';
    }
}
