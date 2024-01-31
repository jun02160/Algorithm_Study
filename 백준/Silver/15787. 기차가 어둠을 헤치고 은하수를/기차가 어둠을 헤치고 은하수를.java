import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());  // 기차의 수
		int M = Integer.parseInt(st.nextToken());  // 명령 수

		int[][] seats = new int[N+1][21];  // 총 N*20개의 좌석
		for (int[] seat : seats) {
			Arrays.fill(seat, 0);  // 전체 0으로 초기화
		}

		int command;
		int train;
		int seat;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			command = Integer.parseInt(st.nextToken());
			train = Integer.parseInt(st.nextToken());
			switch (command) {
				case 1:
					seat = Integer.parseInt(st.nextToken());
					seats[train][seat] = 1;
					break;
				case 2:
					seat = Integer.parseInt(st.nextToken());
					seats[train][seat] = 0;
					break;
				case 3:
					pushBack(seats[train]);
					break;
				case 4:
					pushFront(seats[train]);
					break;
			}
		}

		HashSet<String> result = new HashSet<>();
		for (int i=1; i<=N; i++) {
			result.add(Arrays.toString(seats[i]));
		}
		System.out.println(result.size());
	}

	private static void pushBack(int[] seat) {
		// 1 2 3 4 5

		// 1 0 1 1 0
		// 0 1 0 1 1
		for (int i=20; i>=2; i--) {
			seat[i] = seat[i-1];
		}
		seat[1] = 0;
	}

	private static void pushFront(int[] seat) {
		// 1 0 1 1 0
		// 0 1 1 0 0
		for (int i=1; i<20; i++) {
			seat[i] = seat[i+1];
		}
		seat[20] = 0;
	}
}