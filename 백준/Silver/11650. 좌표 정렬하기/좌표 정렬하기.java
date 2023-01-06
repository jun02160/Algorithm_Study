import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Point implements Comparable<Point> {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x > p.x) {    // x좌표 오름차순 정렬
                return 1;
            } else if (this.x == p.x) {
                if (this.y > p.y) {   // x좌표가 같은 경우, y좌표 오름차순 정렬
                    return 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Point[] points = new Point[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x,y);
        }

        Arrays.sort(points);

        for (int i=0; i<N; i++) {
            System.out.println(points[i].x + " " + points[i].y);
        }
        br.close();
    }



}
