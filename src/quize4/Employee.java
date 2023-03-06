package quize4;

public class Employee extends Member {
    private String specialization;
    private String department;

    public Employee(String name, int age, String phone, String address, double salary, String specialization, String department) {
        super(name, age, phone, address, salary);
        this.specialization = specialization;
        this.department = department;
    }
}
