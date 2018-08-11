package by.training.employeemanager.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacation")
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "Vac_Id")))
public class Vacation extends AbstractEntity {

    @Column(name = "Vac_Employee")
    private Long employeeID;

    @Column(name = "Vac_Date_From")
    private LocalDate dateFrom;

    @Column(name = "Vac_Date_To")
    private LocalDate dateTo;

    @Column(name = "Vac_Approved_By")
    private Long approvedBy;

    public Vacation() {
    }

    public Vacation(Long employeeID, LocalDate dateFrom, LocalDate dateTo, Long approvedBy) {
        this.employeeID = employeeID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.approvedBy = approvedBy;
    }

    public Vacation(Long id, Long employeeID, LocalDate dateFrom, LocalDate dateTo, Long approvedBy) {
        super(id);
        this.employeeID = employeeID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.approvedBy = approvedBy;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "employeeID=" + employeeID +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", approvedBy=" + approvedBy +
                '}';
    }
}