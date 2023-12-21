import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // S (배치 결과)
        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        // D (셔플 규칙)
        int[] shuffle = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            shuffle[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<K; i++) {
            int[] tmp = new int[N];
            for (int j=0; j<N; j++) {
                tmp[shuffle[j]-1] = result[j];
            }
            result = tmp;
        }

        for (int i : result) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
