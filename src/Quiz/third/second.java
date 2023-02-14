package Quiz.third;

public class second {
    public static void main(String[] args) {
        int[] firstArray = {1,2,3,4,5};
        int[] secondArray = firstArray;

        firstArray[2] = 10;
        System.out.println(firstArray==secondArray);
        System.out.println(firstArray.equals(secondArray));
    }
}

