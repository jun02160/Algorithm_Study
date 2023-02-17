import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 소수 배열 구성
        int max = 1299709;
        int[] primes = new int[max+1];
        for (int i=2; i<=max; i++) primes[i] = i;

        for (int i=2; i<=max; i++) {
            if (primes[i] == 0) continue;

            for (int j=2*i; j<=max; j+=i) {
                primes[j] = 0;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int start = -1;
            for (int j=k; j>=2; j--) {
                if (primes[j] != 0) {
                    start = j;
                    break;
                }
            }
            int end = -1;
            for (int j=start+1; j<=max; j++) {
                if (primes[j] != 0) {
                    end = j;
                    break;
                }
            }

            if (primes[k] != 0) sb.append(0).append("\n");
            else if (start < k && end > k) sb.append(end-start).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);

    }
}
