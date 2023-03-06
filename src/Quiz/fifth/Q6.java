package Quiz.fifth;

public class Q6 {
    public static void main(String[] args) {

    }
}

class A {
    int i;
    A(int i){
        this.i= i;
    }
}

class B extends A{
    int j;
    B(int i, int j){
        this.j = j;
        super(i);
    }
}
