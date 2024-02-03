import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int count = 0;
		for (int i=1; i<=N; i++) {
			int pow = i*i;
			int B = pow + N;
			if (Math.pow((int)Math.sqrt(B),2) == B) {
				count++;
			}
		}
		System.out.println(count);
	}
}