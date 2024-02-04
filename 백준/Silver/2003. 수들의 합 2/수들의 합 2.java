import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numArr= new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;  // 정답
		int now = 0;
		// 투 포인터로 접근
		for (int i=0, j=0; j<N; j++) {
			now += numArr[j];
			while (now > M) now -= numArr[i++];
			if (now == M) ans++;
		}
		System.out.println(ans);
    }
}