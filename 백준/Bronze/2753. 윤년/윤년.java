import java.util.Scanner;

public class Main {
    public static int isLeapYear(int year) {
        if((year%4==0 && year%100 !=0) || year%400==0)
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int year = input.nextInt();

        input.close();

        if (isLeapYear(year) == 1) 
            System.out.println(1);
        else 
            System.out.println(0);
    }
}