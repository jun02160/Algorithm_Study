import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());  // 동생 수
		int S = Integer.parseInt(st.nextToken());  // 수빈의 위치

		int[] pos = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
			pos[i] = getPos(S, pos[i]);
		}

		int result = gcd(pos[0], pos[0]);
		// D의 값으로 갱신하기
		for (int i=0; i<N-1; i++) {
			result = Math.min(result, gcd(pos[i], pos[i+1]));
			// System.out.println(result);
		}


		System.out.println(result);
	}

	private static int getPos(int p1, int p2) {
		return Math.abs(p1-p2);
	}

	// 최대공약수
	private static int gcd(int a, int b) {
		return b > 0 ? gcd(b, a%b) : a;
	}
}
