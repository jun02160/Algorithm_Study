import java.io.*;
import java.util.*;

public class Main {

	private static String str1;
	private static String str2;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine();
		str2 = br.readLine();

		dp = new int[str1.length()+1][str2.length()+1];   // 공통된 부분 문자열을 표시하기 위한 2차원 배열

		System.out.println(LIS());
	}

	// Bottom-Up 방식
	private static int LIS() {
		str1 = " " + str1;
		str2 = " " + str2;

		for (int i=1; i<str1.length(); i++) {
			for (int j=1; j<str2.length(); j++) {
				 // 점화식: dp[i] = max(dp[j]+1)
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);   // 같은 원소라면 직전 대각선에서 1 더한 값으로
				}
			}
		}
		return dp[str1.length()-1][str2.length()-1];
	}
}