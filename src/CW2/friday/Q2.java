package CW2.friday;

public class Q2 {
    public static void main(String[] args) {
        String sampleText = "this is something to consider coding with";
        Character[] listOfVowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int numberOfVowels = getNumberOfVowels(sampleText,listOfVowels);
        int numberOfTotal = getTotalCharacters(sampleText);
        System.out.println(numberOfTotal-numberOfVowels);
//        System.out.println(getNumberOfVowels(sampleText, listOfVowels));
//        System.out.println(getTotalCharacters(sampleText));



    }

    private static int getNumberOfVowels(String text, Character[] vowels) {
        char[] listOfChars = text.toCharArray();
        int counter = 0;

        for (char textChar : listOfChars) {
            for (char vowelChar : vowels) {
                if (textChar == vowelChar) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int getTotalCharacters(String text) {
        int counter = 0;
        for (Character character :
                text.toCharArray()) {
            if (!Character.isWhitespace(character)) {
                counter++;
            }
        }
        return counter;
    }
}
