import java.util.*;
public class Palindrome {
    public static void main(String[] args) throws Exception {
      int remainder, sum =0, temp;
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check if it is palindrome or not : ");
          int n = sc.nextInt();
          sc.close();
          temp = n;
          while (n>0){
            remainder = n%10;
            sum = (sum*10)+remainder;
            n = n/10;
          }
    
      if(temp == sum){
        System.out.println("Given number is a Palindrome");
        
      }else {
        System.out.println("Given number is not a palindrome");
      }
    }
}

