
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken()); // 학생 수 = 그래프의 정점
        int M = Integer.parseInt(stk.nextToken()); // 그래프의 간선

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                que.offer(i);
        }
        while (!que.isEmpty()) {
            int now = que.poll();
            System.out.print(now + " ");
            for (int cur : graph.get(now)) {
                indegree[cur]--;
                if (indegree[cur] == 0)
                    que.offer(cur);
            }
        }
    }

}