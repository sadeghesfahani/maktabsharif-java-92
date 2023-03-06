package quize4;

public class Q1 {
    public static void main(String[] args) {
        Member member = new Member("sina", 21, "+989035013470", "tehran", 800);
        Employee emp = new Employee("sina", 31, "+989035013470", "tehran", 800, "UI", "IT");
        Manager mng = new Manager("sina", 31, "+989035013470", "tehran", 800, "UI", "IT");
        member.printSalary();
        emp.printSalary();
        mng.printSalary();
    }
}


