import java.io.*;

public class Main {
    static char[][] color;
    static boolean[][][] visited;

    static int[] dx = { -1, 1, 0, 0 };   // 좌우
    static int[] dy = { -0, 0, -1, 1 };  // 상하

    static int N;
    static int[] ans;  // 정답(적록색약X / 적록색약O)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new char[N][N];
        visited = new boolean[N][N][2];
        ans = new int[2];

        for (int i=0; i<N; i++) {
            String t = br.readLine();
            for (int j=0; j<t.length(); j++) 
                color[i][j] = t.charAt(j);
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<2; k++) {
                    if (!visited[i][j][k]) {
                        dfs(i, j, k);
                        ans[k]++;
                    }
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    static void dfs(int i, int j, int k) {
        visited[i][j][k] = true;  // 방문으로 표시

        // 상하좌우로 적록색맹 구간이 존재하는지 체크
        for (int t=0; t<4; t++) {
            int nx = i + dx[t];
            int ny = j + dy[t];

            // 유효하지 않은 범위
            if (nx < 0 || nx >= N || ny < 0 | ny >= N) continue;

            // 1. 색이 같으면 OK
            boolean check = (color[nx][ny] == color[i][j]);

            // 2. R-G / G-R이어도 OK (적록색맹인 사람만 검사)
            if (k == 1) {
                if (color[nx][ny] == 'R' && color[i][j] == 'G') check = true;
                if (color[nx][ny] == 'G' && color[i][j] == 'R') check = true;
            }

            if (!visited[nx][ny][k] && check) dfs(nx, ny, k);
        }
    }
}
