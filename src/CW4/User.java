package CW4;

public class User {
    private String name;
    private String nationalId;

    User(String name, String nationalId) {
        this.name = name;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }
}
