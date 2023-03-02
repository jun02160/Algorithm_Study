import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> cards = new HashMap<>();
        for (int i=0; i<M; i++) {
            long num = Long.parseLong(st.nextToken());
            cards.put(num, cards.getOrDefault(num, 0)+1);
        }

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            long num = Long.parseLong(st.nextToken());
            if (cards.containsKey(num)) {
                sb.append(cards.get(num)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
