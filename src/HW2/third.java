package HW2;

public class third {
public static int calculateWaterLevel(int[] heights) {
    int waterLevel = 0;
    int n = heights.length;
    int leftMax = 0;
    int rightMax = 0;
    int left = 0;
    int right = n - 1;
    while (left < right) {
        if (heights[left] < heights[right]) {
            if (heights[left] > leftMax) {
                leftMax = heights[left];
            } else {
                waterLevel += leftMax - heights[left];
            }
            left++;
        } else {
            if (heights[right] > rightMax) {
                rightMax = heights[right];
            } else {
                waterLevel += rightMax - heights[right];
            }
            right--;
        }
    }
    return waterLevel;
}

    public static void main(String[] args) {
    //  {       4,5,4,5,4
//        int[] heights = {1, 2, 0, 3, 1, 0, 1, 2, 2, 1, 2, 0, 1};
        int[] heights = {3,0,2,0,4};
        int waterLevel = calculateWaterLevel(heights);
        System.out.println("Water level: " + waterLevel);
    }

}
