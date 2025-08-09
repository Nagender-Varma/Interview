
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {879, 45, 440, 324, 78, 124, 568};
        System.out.println("Initialized Array as follows");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sorting begins");

        bubbleSort(arr);

    }

    private static void bubbleSort(int[] arr) {

        int pass = 1;
        int lengthOfArray = arr.length;  // 7

        for (int i = 0; i < lengthOfArray - 1; i++) {
            System.out.println("Outer loop : " + pass);
            pass++;

            for (int j = 0; j < lengthOfArray - i - 1; j++) {
                System.out.println();

                System.out.println("Inner Loop Values for i = " + i + " and j = " + j);
                System.out.println();

                System.out.println("Before Swapping array");
                System.out.println(Arrays.toString(arr));
                System.out.println();
                if (arr[j] > arr[j + 1]) {
                    System.out.println("Swapping " + arr[j] + " and " + arr[j + 1]);
                    System.out.println();

                    int temp = arr[j]; // temp = 879
                    arr[j] = arr[j + 1]; // arr[j] is also 879,  now arr[j] will be assigned with arr[j+1] 45
                    arr[j + 1] = temp; // arr[j=1] which 45 is already assigned to arr[j], now the value from temp is assiged to arr[j+1] which 879
                    System.out.println("After Swapping");
                }
                System.out.println(Arrays.toString(arr));

            }

        }
    }
}
