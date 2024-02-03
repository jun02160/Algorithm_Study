import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static int M;
	private static StringBuilder sb;

	private static int[] ans;
	private static boolean[] choose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		choose = new boolean[N+1];  // 중복X => 해당 수를 이미 선택했는지 검사
		ans = new int[M];  // 조합의 크기는 M

		solve(0);

		System.out.println(sb);
	}

	private static void solve(int ch) {
		if (ch == M) {
			for (int num : ans) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}


		for (int i=1; i<=N; i++) {  // 4

			if (!choose[i]) {
				choose[i] = true;
				ans[ch] = i;
				solve(ch+1);
				choose[i] = false;
			}
		}
	}
}