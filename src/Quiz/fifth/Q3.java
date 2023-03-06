package Quiz.fifth;

public class Q3 {
    public static void main(String[] args) {
        Base b = new Derived();
        b.show();
    }

//    b.show()
}

class Base1{
    public static void show(){
        System.out.println("Base::show() called");
    }
}

class Derived1 extends Base{

    public void show() {
        System.out.println("Derived:show() called");
    }
}
