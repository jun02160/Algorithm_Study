import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];   // 크기 N의 배열 선언

		// 배열 채워 넣기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 결과 배열 생성 및 출력
		int[] result = new int[N];

		/**
		 * 3 5 2 7
		 * -> 7
		 * ->
		 */
		Stack<Integer> stack = new Stack<>();
		for (int i = N-1; i >= 0; i--) {  // 오른쪽부터 순회
			while (!stack.empty() && stack.lastElement() <= arr[i])
				stack.pop();
			result[i] = (stack.empty() ? -1 : stack.lastElement());
			stack.push(arr[i]);
		}
        
		StringBuilder sb = new StringBuilder();
		for (int num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
