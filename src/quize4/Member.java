package quize4;

public class Member {
    private String name;
    private int age;
    private String phone;
    private String address;
    private double salary;


    public Member(String name, int age, String phone, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Salary: " + this.salary);
    }
}
