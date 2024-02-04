import java.io.*;

public class Main {

	static long N;
	static long K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Long.parseLong(br.readLine());
		K = Long.parseLong(br.readLine());

		long left = 1;
		long right = K;

		while (left < right) {
			long mid = (left+right) / 2;

			if (decision(mid)) right = mid;
			else left = mid+1;
		}

		System.out.println(left);
	}

	private static boolean decision(long mid) {
		long cnt = 0;
		for (int i=1; i<=N; i++) cnt += Math.min(mid / i, N);
		return cnt >= K;
	}
}
