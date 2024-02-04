import java.util.*;
import java.io.*;

public class Main {

	private static int n;
	private static int[] arr;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		dp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(LIS());
	}

	// Bottom-Up 방식
	private static int LIS() {
		int ret = 0;
		for (int i=0; i<n; i++) {
			dp[i] = 1;   // 초기 조건
			for (int j=0; j<i; j++) {
				if (arr[j] < arr[i])
					dp[i] = Math.max(dp[i], dp[j]+1);  // 점화식: dp[i] = max(dp[j]+1)
			}
			ret = Math.max(ret, dp[i]);
		}
		return ret;

	}
}