package Fibonacci.src;

//Print pattern in right angle triangle using Fibonacci Numbers

// Output 
//1
//1	2
//3	5	8
//13 21	34

//@Author Nagender Varma
// Date June 18th 2021

public class Fibonacci{
    public static void main(String[] args) {
        int i;
        int j;
        int firstNumber = 0;
        int secondNumber = 1;
        int sum = firstNumber + secondNumber;
        for (i = 0; i <= 5; i++) { // Loop 1
            for (j = 0; j <= i; j++) { // Loop 2
                System.out.print(" " + sum);
                sum = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = sum;

            }
            System.out.print("\n"); // to print in new line
        }
    }
}

/// Expected Output in Console