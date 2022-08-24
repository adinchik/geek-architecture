package composite;

public class MainClass {
    public static void main(String[] args) {
        Employee John = new Developer("John", 12000);
        Employee Jane = new Designer("Jane", 15000);

        Organization organization = new Organization();
        organization.addEmployee(John);
        organization.addEmployee(Jane);
        System.out.println("Net salaries: " + organization.getNetSalaries());
    }
}
