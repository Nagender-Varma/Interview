import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {5, 3, 40, 10, 2};
        System.out.println("Original Array:");
        printArray(arr);
        System.out.println("Bubble Sort Execution Steps");
        bubbleSort(arr);
        System.out.println("Sorted Array");
        printArray(arr);

    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    private static void bubbleSort(int[] arr) {
        int pass = 1;
        int lengthOfArray = arr.length;
        for (int i = 0; i < lengthOfArray - 1; i++) {
            System.out.println("Outer Loop Pass  " + pass);
            pass++;
            for (int j = 0; j < lengthOfArray - i - 1; j++) {
                System.out.println("Inner Loop Iteration (i = " +
                        i + ", j =" + j + ")");
                System.out.println("Before Swapping");
                System.out.println(Arrays.toString(arr));
                if(arr[j]>arr[j+1]){
                    System.out.println("Swapping " + arr[j] + " and " + arr[j+1]);
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                }
                printArray(arr);
            }
            System.out.println();

        }


    }
}

