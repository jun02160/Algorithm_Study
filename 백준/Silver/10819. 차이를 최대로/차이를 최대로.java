import java.util.*;
import java.io.*;

public class Main {

	private static int N;
	private static int[] arr;
	private static int[] ans;
	private static boolean[] visit;
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		ans = new int[N];
		visit = new boolean[N];

		for (int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		solve(0);

		System.out.println(result);
	}


	private static void solve(int ch) {
		if (ch == N) {
			int sum = 0;
			for (int i=0; i<N-1; i++) {
				sum += Math.abs(ans[i]-ans[i+1]);
			}
			result = Math.max(result, sum);
			return;
		}


		for (int i=0; i<N; i++) {  // 4

			if (!visit[i]) {
				visit[i] = true;
				ans[ch] = arr[i];
				solve(ch+1);
				visit[i] = false;
			}
		}
	}
}