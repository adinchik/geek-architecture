package composite;

public abstract class Employee {
    protected String name;
    protected float salary;

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract public String getName();

    abstract public float getSalary();

    abstract void setSalary(float salary);
}
