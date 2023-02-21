package Quiz.forth;

public class seventeenth {
    public static void main(String[] args) {
        Circle a = new Circle(0);
//        Circle b = new Circle(null);
//        Circle c = new Circle();
//        Circle[] d = new Circle[10];

    }
}

public class Circle{
    private double radius;
    public Circle(double r){
        radius = r;
    }

    public double getArea(){
        return radius * radius * 3.14;
    }


}
