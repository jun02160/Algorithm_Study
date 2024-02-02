import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow_calc(A, B, C) % C);
    }

    public static long pow_calc(long a, long b, long c){
        // * 분할정복 | A의 지수가 짝수인지, 홀수인지로 구분
        if(b == 0){
            return 1;
        } else if(b == 1){
            return a;
        } else if(b % 2 == 0){
            long result = pow_calc(a, b/2, c) % c;
            return (result*result) % c;
        } else{
            long result = pow_calc(a, b/2, c) % c;
            return (((result*result) % c) * a) % c;
        }
    }
}