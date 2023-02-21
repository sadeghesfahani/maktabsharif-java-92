public class Kelas {
    public static String[] classes = new String[10];
    static private int index = 0;
    String name;

    public Kelas(String name) {
        this.name = name;
        Kelas.classes[index++] = name;
    }
}
