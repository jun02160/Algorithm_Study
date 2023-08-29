import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long p = 1000000007;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n, k;
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
//        System.out.println("n, k = " + n + " " +k);

        long top = factorial(n);
        long bottom = factorial(n-k) * factorial(k) % p;

        System.out.println(top * power(bottom, p-2) % p);

    }

    private static long factorial(long n) {
        long result = 1;
        for (int i=2; i<=n; i++)
            result = (result * i) % p;
//        System.out.println("팩토리얼 result: " + result);
        return result;
    }

    private static long power(long x, long n) {
        if (n == 1) return x % p;

        long tmp = power(x, n/2);
        if (n % 2 == 0) return tmp*tmp%p;
        else return (tmp*tmp%p)*x%p;
    }

}
