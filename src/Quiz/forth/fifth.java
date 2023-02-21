package Quiz.forth;

public class fifth {
    public static void main(String[] args) {
        long number = 10L;
        Example example = new Example(number);
    }
}


class Example{
    public Example(long number){
        System.out.println("long");
    }
    public Example(int number){
        System.out.println("int");
    }
}
