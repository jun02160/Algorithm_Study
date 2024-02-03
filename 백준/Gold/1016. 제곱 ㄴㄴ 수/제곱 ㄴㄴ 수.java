import java.util.*;
import java.io.*;

/**
 * 제곱인 수를 찾자!
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		// 제곱에 해당하는 수 체크
		long count = max-min+1;
		boolean[] check = new boolean[(int)count];
		for (long i=2;i*i<=max; i++) {
			long pow = i*i;  // 제곱수 (6, 10) 6/4
			long div = min / pow;  // 1
			if (min % pow != 0) {
				div += 1;  // 2
			}

			for (long j=div; j*pow<=max; j++) {
				int sqrt = (int)(j*pow-min);
				if (!check[sqrt]) {
					check[sqrt] = true;
					count--;
				}
			}
		}

		System.out.println(count);
	}
}