package Quiz.third;

public class first {
    public static void main(String[] args) {
        String name1 = "Ali";
        String name2 = "Ali";
        System.out.println(name1.equals(name2));
        System.out.println(name1==name2);
        String name3 = name1.intern();
        System.out.println(name3==name2);
    }
}
