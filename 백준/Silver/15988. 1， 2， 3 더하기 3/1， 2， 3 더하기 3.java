import java.io.*;

public class Main {

	private static BufferedReader br;
	private static StringBuilder sb;

	private static final int N = 1000001;
	private static long[] dp = new long[N];
	private static int MOD = 1000000009;
	private static int T;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		// 점화식 : dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
		solve1();
		// solve2();
		System.out.println(sb);
	}

	// Bottom Up
	private static void solve1() throws IOException {

		// 초기 조건
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i=4; i<N; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
		}

		while (T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}
	}

}