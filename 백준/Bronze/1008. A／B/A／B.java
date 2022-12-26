import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());

        if(a%b == 0) System.out.println(a/b);
        else System.out.println((double) Math.round(a/b*1000000000) / 1000000000);
    }
}
