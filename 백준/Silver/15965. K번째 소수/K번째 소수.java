import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] check = new boolean[10000001];
		List<Integer> primeList = new ArrayList<>();
		int n = 10000000;

		for (int i=2; i<=n; i++) {
			if (!check[i]) {
				primeList.add(i);
				for (int j=i+i; j<=n; j+=i) {
					check[j] = true;
				}
			}
		}

		int K = Integer.parseInt(br.readLine());
		System.out.println(primeList.get(K-1));
	}
}