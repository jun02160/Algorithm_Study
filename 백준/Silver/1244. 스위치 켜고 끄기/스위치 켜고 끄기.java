import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());  // 스위치 개수
		int[] switchs = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<N+1; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		switchs[0] = -1;

		st = new StringTokenizer(br.readLine());
		int student = Integer.parseInt(st.nextToken());  // 학생 수
		for (int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			switch (gender) {
				case 1:
					for (int j=1; j<=N; j++) {
						if (j % num == 0) {
							transNum(switchs, j);
						}
					}
					break;
				case 2:
					if (num>=N || num<=1 || N==2) {
						transNum(switchs, num);
						break;
					}

					if (switchs[num+1] != switchs[num-1]) {
						transNum(switchs, num);
						break;
					}

					int j = 0;
					while (num - j > 0 && num + j <= N && switchs[num - j] == switchs[num + j]) {
						j++;
					}

					j -= 1;
					if (num+j<=N && num-j>=1) {
						for (int k = num - j; k <= num + j; k++)
							transNum(switchs, k);
					}

					break;
			}
		}

		for (int i=1; i<=N; i++) {
			System.out.print(switchs[i]);
			System.out.print(" ");
			if (i % 20 == 0)
				System.out.println();
		}
	}
	private static void transNum(int[] switchs, int idx) {
		if (idx != 0 && idx != switchs.length+1) {
			if (switchs[idx] == 1) {
				switchs[idx] = 0;
			} else {
				switchs[idx] = 1;
			}
		}
	}
}
