import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int max = -1000000;
        int min = 1000000;

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (max < num) max = num;
            if (min > num) min = num;
        }

        bw.write(String.valueOf(min) + " " + String.valueOf(max));

        br.close();
        bw.close();
    }
}
