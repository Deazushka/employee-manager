package by.training.employeemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "profession")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Prf_Id")))
public class Profession extends AbstractEntity {

    @Column(name = "Prf_Profession")
    private String professionName;

    @Column(name = "Prf_Salary")
    private Long salary;

    public Profession() {
    }

    public Profession(String professionName, Long salary) {
        this.professionName = professionName;
        this.salary = salary;
    }

    public Profession(Long id, String professionName, Long salary) {
        super(id);
        this.professionName = professionName;
        this.salary = salary;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "professionName='" + professionName + '\'' +
                ", salary=" + salary +
                '}';
    }
}