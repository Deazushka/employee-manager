package by.training.employeemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Dep_Id")))
public class Department extends AbstractEntity {

    @Column(name = "Dep_Name")
    private String department;

    public Department() {
    }

    public Department(String department) {
        this.department = department;
    }

    public Department(Long id, String department) {
        super(id);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department='" + department + '\'' +
                '}';
    }
}
