import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n1;
		int n2;
		
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		sc.close();
		
		int result = gcd(n1, n2);
		
		System.out.println(result);
        System.out.println(n1*n2/result);	
	}

    private static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
