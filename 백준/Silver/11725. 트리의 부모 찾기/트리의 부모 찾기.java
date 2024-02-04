import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] p;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		graph = new ArrayList[N+1];
		for (int i=0; i<=N; i++) graph[i] = new ArrayList<>();

		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		dfs(1);
		for (int i=2; i<=N; i++)
			System.out.println(p[i]);
	}

	static void dfs(int x) {
		for (int n : graph[x]) {
			if (p[n] <= 0) {
				p[n] = x;
				dfs(n);
			}
		}
	}
}