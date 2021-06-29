
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st word :");
        String s1= sc.nextLine();
        System.out.println("Enter 2nd word :");
        String s2= sc.nextLine();
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        sc.close();
        System.out.println(solve(ch1, ch2));

       
    }

    public static boolean solve(char[] ch1, char[] ch2) {
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if (Arrays.equals(ch1, ch2)) {
            return true;
        }

        return false;
    }

}
