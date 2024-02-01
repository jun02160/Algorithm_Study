import java.io.*;
import java.util.*;

public class Main {
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());  // 구간의 크기

		/**
		 * 1 5 2 3
		 * L = 3
		 * 1-3+1~1 = -1~1
		 * 2-3+1~2 = 0~2
		 * 3-3+1~3 = 1~3
		 * 4-3+1~4 = 2~4
		 * 구간 찾기 -> 최솟값 추출  *구간의 크기는 L로 고정
		 */
		Deque<Pair> queue = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {

			int num = Integer.parseInt(st.nextToken());

			while (!queue.isEmpty() && queue.peekLast().value > num) {
				queue.pollLast();    // 남아있는 값 중에 최솟값 후보가 아닌 건 모두 제거
			}

			queue.addLast(new Pair(i, num));    // 자신의 turn에는 넣고 시작
			if (queue.peekLast().id - queue.peekFirst().id >= L) { // 올바른 구간에만 적용하기 위해 제거
				queue.pollFirst();
			}

			sb.append(queue.peekFirst().value).append(" ");
		}
		System.out.println(sb);
	}

	static class Pair {
		int id;
		int value;

		Pair(int id, int value) {
			this.id = id;
			this.value = value;
		}
	}
}