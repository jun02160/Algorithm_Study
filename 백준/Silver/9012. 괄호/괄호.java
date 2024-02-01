import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i=0; i<N; i++) {
			String sol = br.readLine();
			sb.append(judge(sol) + "\n");
		}
		System.out.println(sb);

	}

	private static String judge(String sol) {
		int open = 0;

		for (int i=0; i<sol.length(); i++) {
			if (sol.charAt(i) == '(') {
				open++;
			} else {
				open--;
			}
            
            if (open < 0) {
				return "NO";
			}
		}

		if (open != 0) {
			return "NO";
		}
		return "YES";
	}
}