import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> numsMap = new HashMap<>();
        int max = 0;
        long n = 0;
        for (int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);   // key가 이미 존재하면 value값 반환, 없으면 디폴트 값 반환

            if (numsMap.get(num) > max) {
                max = numsMap.get(num);
                n = num;
            } else if (numsMap.get(num) == max) {
                if (n > num) n = num;
            }
        }
        System.out.println(n);
    }
}
