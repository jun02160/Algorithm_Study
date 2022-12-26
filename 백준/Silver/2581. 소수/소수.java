import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = -1;
        boolean flag = false;
        for (int i=M; i<=N; i++) {
            if (isPrior(i)) {
                sum += i;
                if (!flag) {
                    min = i;
                    flag = true;
                }
            }
        }

        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    public static boolean isPrior(int n) {
        int i;
        for(i=2; i<n; i++) {
            if (n % i == 0) break;
        }
        if (i==n) return true;
        else return false;
    }
}
