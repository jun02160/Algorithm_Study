import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		sb.append(gcd(a, b)).append("\n");
		sb.append(lcm(a, b)).append("\n");
		System.out.println(sb);
	}

	// 최대공약수
	private static int gcd(int a, int b) {
		return b > 0 ? gcd(b, a%b) : a;
	}

	// 최소공배수
	private static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}




}