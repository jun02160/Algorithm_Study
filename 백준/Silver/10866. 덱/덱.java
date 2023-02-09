
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
//            System.out.println(String.valueOf(deque.isEmpty()) + " size: " + deque.size());

            if (deque.isEmpty() && (command.equals("pop_front") || command.equals("pop_back") || command.equals("front") || command.equals("back"))) {
                sb.append(-1).append("\n");
                command = "";
            }

            switch (command) {
                case "push_back":
                    int num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                case "push_front":
                    int num2 = Integer.parseInt(st.nextToken());
                    deque.addFirst(num2);
                    break;
                case "empty":
                    int num4 = deque.isEmpty() ? 1 : 0;
                    sb.append(num4).append("\n");
                    break;
                case "front":
                    sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(deque.peekLast()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.pollLast()).append("\n");
                    break;
                case "pop_front":
                    sb.append(deque.poll()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
