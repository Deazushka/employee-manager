package by.training.employeemanager.model;

public class SalaryResult {
    private String name;
    private Long rate;
    private Long bonus;
    private Long total;

    public SalaryResult() {
    }

    public SalaryResult(String name, Long rate, Long bonus, Long total) {
        this.name = name;
        this.rate = rate;
        this.bonus = bonus;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SalaryResult{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", bonus=" + bonus +
                ", total=" + total +
                '}';
    }
}
