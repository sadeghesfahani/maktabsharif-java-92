package CW3;

class Q4 {

    public static void main(String[] args) {

    }
}


class Employee{
    private String firstName;
    private String lastName;
    private float salary;
    public Employee(String firstName, String lastName,float salary){
        this.firstName=firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }


    public void setSalary(float salary){
        this.salary = salary;
    }

    public float getSalary(){
        return salary;
    }



}
