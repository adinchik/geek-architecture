package composite;

public class Developer extends Employee{

    public Developer(String name, float salary) {
        super(name, salary);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getSalary() {
        return salary;
    }

    @Override
    void setSalary(float salary) {
        this.salary = salary;
    }
}
