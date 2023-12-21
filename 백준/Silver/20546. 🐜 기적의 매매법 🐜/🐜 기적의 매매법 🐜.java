import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cash = Integer.parseInt(br.readLine());
        int jcash, scash;  // 준현&성민의 초기 현금
        jcash = cash;
        scash = cash;

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1일 ~ 14일의 주가
        int[] stock = new int[14];
        for (int i=0; i<14; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }

        // 1/14 총 자산
        // 준현
        jcash = BNP(jcash, stock);

        // 성민
        scash = TIMING(scash, stock);

        // 결과 비교
        if (jcash > scash) {
            System.out.println("BNP");
        } else if (jcash < scash) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int BNP(int jcash, int[] stock) {

        int jcnt = 0;

        for (int i=0; i<14; i++) {
            int cnt = jcash / stock[i];
            jcnt += cnt;
            jcash -= stock[i]*cnt;
        }

        return jcash + stock[13] * jcnt;
    }

    private static int TIMING(int scash, int[] stock) {

        int scnt = 0;

        for (int i=3; i<14; i++) {
            if (scash >= stock[i]*scnt) {
                // 3일 전부터 연속 증가
                if (stock[i-3] < stock[i-2] && stock[i-2] < stock[i-1] && stock[i-1] < stock[i]) {
                    // 전량 매도
                    scash += stock[i] * scnt;
                    scnt = 0;
                } else if (stock[i-3] > stock[i-2] && stock[i-2] > stock[i-1] && stock[i-1] > stock[i]) { // 3일 연속 하락
                    // 전량 매수
                    int cnt = scash / stock[i];
                    scnt += cnt;
                    scash -= stock[i]*cnt;
                }
            }
        }

        return scash + stock[13] * scnt;
    }
}
