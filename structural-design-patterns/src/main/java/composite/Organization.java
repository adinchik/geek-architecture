package composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private List<Employee> employees;

    public Organization() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public float getNetSalaries() {
        float netS = 0;
        for(Employee employee: employees) {
            netS += employee.getSalary();
        }
        return netS;
    }
}
