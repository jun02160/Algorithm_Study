import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[] arr;
	private static int[] ans;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		dp = new int[n];
		ans = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		LIS();
	}

	// Bottom-Up 방식
	private static void LIS() {
		int maxIdx = 0;

		for (int i=0; i<n; i++) {

			ans[i] = -1;
			dp[i] = 1;   // 초기 조건
			for (int j=0; j<i; j++) {

				// index를 저장
				if (arr[j] < arr[i] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j] + 1;  // 점화식: dp[i] = max(dp[j]+1)
					// System.out.println(dp[i]);
					ans[i] = j;
				}
			}
			if (dp[i] > dp[maxIdx])
				maxIdx = i;
			// System.out.println(maxIdx);
		}

		System.out.println(dp[maxIdx]);
		ArrayList<Integer> result = new ArrayList<>();

		for (int i=maxIdx; i != -1; i=ans[i]) {
			result.add(i);
		}
		for (int i=result.size()-1; i>=0; i--)
			System.out.print(arr[result.get(i)] + " ");
	}
}
