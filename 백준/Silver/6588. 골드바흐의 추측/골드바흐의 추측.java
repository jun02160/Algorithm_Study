import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 소수 배열 구성
        int max = 1000000;
        int[] primes = new int[max+1];
        for (int i=2; i<=max; i++) primes[i] = i;

        for (int i=2; i<=max; i++) {
            if (primes[i] == 0) continue;

            for (int j=2*i; j<=max; j+=i) {
                primes[j] = 0;
            }
        }

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {

            boolean isPrime = false;
            for (int i=2; i<=n/2; i++) {
                if (primes[i] != 0 && primes[n-i] != 0) {
                    sb.append(n + " = " + String.valueOf(i) + " + " + String.valueOf(n-i)).append("\n");
                    isPrime = true;
                    break;
                }
            }
            if (!isPrime) sb.append("Goldbach's conjecture is wrong.").append("\n");

            n = Integer.parseInt(br.readLine());

        }

        System.out.println(sb);
    }
}
