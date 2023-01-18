import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        long fx[] = new long[1000001]; // 해당 자연수의 모든 약수를 더한 변수 
        long gn[] = new long[1000001]; // 해당 자연수 이하의 모든 fx값을 더한 변수

        // 1은 모든 자연수의 약수이므로 전체 배열에 채워줌
        Arrays.fill(fx, 1);

        // i * j = x 일 때 i, j 는 x 의 약수이다.
        // i * j까지만 반복한다. 2 * 500,000 = 1,000,000
        for(int i=2; i<fx.length; i++) {
            for(int j=1; i*j <fx.length; j++) {
            	fx[i*j] += i; 
            }
        }

        for(int i = 1; i < gn.length; i++) {
       		gn[i] = gn[i-1] + fx[i];
        }

        while(count-- > 0) {
        	int input = Integer.parseInt(br.readLine());
        	sb.append(gn[input]).append("\n");
        }

        System.out.println(sb);
    }
}