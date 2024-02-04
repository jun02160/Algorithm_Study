import java.util.*;
import java.io.*;

public class Main {

	static long staff;
	static long balloon;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		staff = Integer.parseInt(st.nextToken());
		balloon = Integer.parseInt(st.nextToken());
		long[] times = new long[(int)staff];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<staff; i++) times[i] = Long.parseLong(st.nextToken());
		Arrays.sort(times);

		/**
		 * balloon이 다 만들어지는 데 걸리는 최소 시간 (최적화 문제-파라메트릭 서치)
		 * * NNNNYYYY -> 처음 Y가 나오는 위치를 찾기 위해 이분 탐색으로 접근 (범위를 점점 좁혀나가기)
		 */
		long left = 1;
		long right = times[(int)(staff-1)]*balloon;
		while (left < right) {
			long mid = (left + right) / 2;
			// System.out.println("mid = " + mid);
			// System.out.println("right = " + right);
			// System.out.println("left = " + left);

			if (decision(mid, times)) right = mid;
			else left = mid+1;
		}

		System.out.println(right);

	}

	private static boolean decision(long mid, long[] arr) {
		long cnt = 0;
		for (long num : arr) cnt += (mid / num);
		return cnt >= balloon;
	}
}
