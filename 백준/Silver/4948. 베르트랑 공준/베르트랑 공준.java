import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            sb.append(getPrimeCnt(n)).append("\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }

    private static int getPrimeCnt(int n) {
        int[] arr = new int[n*2+1];
        for (int i=2; i<=2*n; i++) {
            arr[i] = i;
        }

        for (int i=2; i<=2*n; i++) {
            if (arr[i] == 0) continue;

            for (int j=2*i; j<=2*n; j+=i) {
                arr[j] = 0;
            }
        }

        int cnt = 0;
        for (int i=n+1; i<=2*n; i++) {
            if (arr[i] != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
