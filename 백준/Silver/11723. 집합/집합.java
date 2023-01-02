import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int bitMask = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("empty") || cmd.equals("all")) {
                commands(cmd);
                continue;
            }

            int x = Integer.parseInt(st.nextToken());
            commands(cmd, x);
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    public static void commands(String cmd) {
        switch (cmd) {
            case "all":
                bitMask = ~0;
                break;
            case "empty":
                bitMask = 0;
                break;
        }
    }

    public static void commands(String cmd, int x) {
        switch (cmd) {
            case "add":
                bitMask = bitMask | 1 << (x-1);
                break;
            case "remove":
                bitMask = bitMask & ~(1 << (x-1));
                break;
            case "check":
                sb.append(((bitMask & 1 << (x-1)) == 1 << (x-1) ? 1 : 0) + "\n");
                break;
            case "toggle":
                bitMask = bitMask ^ 1 << (x-1);
                break;
        }
    }
}
