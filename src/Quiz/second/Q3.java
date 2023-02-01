package Quiz.second;

public class Q3 {
    public static void main(String[] args) {
        String text = "Hello";
        System.out.println(text.charAt(2)); // third character of string will be 2 in index ["H","e","*l","l","o"]

        // one possibility would be like this:
        char character = 'A';
        String convertedToString = Character.toString(character); // this is using private method of abstract layer over characters

        // another possibility would be:
        Character anotherCharacter = 'A';
        String convertedToStringViaAnotherCharacter = anotherCharacter.toString(); // this is using Boxing
    }
}
