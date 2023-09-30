package Arrays;

import java.util.*;
// Rotate an array of n elements to the right by k steps. For example, with n
// = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

public class RotateArray1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values into array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the step number to rotate array : ");
        int k = sc.nextInt();
        System.out.println("Values given for array : ");

        System.out.println(Arrays.toString(arr));

        rotateArray(arr, k);
    }

    private static void rotateArray(int[] arr, int k) {

        if (k > arr.length) {
            k = k % arr.length;

        }

        int[] results = new int[arr.length];
        for (int i = 0; i < k; i++) {
            results[i] = arr[arr.length - k + i];

        }

        int j = 0;

        for (int i = k; i < arr.length; i++) {
            results[i] = arr[j];
            j++;
        }
        System.arraycopy(results, 0, arr, 0, arr.length);
        System.out.println("Array after rotation by given steps ");

        System.out.println(Arrays.toString(arr));

    }
}