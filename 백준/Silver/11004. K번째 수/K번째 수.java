import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 퀵 정렬을 이용하여 정수배열 정렬
        quickSort(nums, 0, N-1);

        bw.write(String.valueOf(nums[K-1]));   // BufferedWriter 를 사용하려면 String 형으로 변환이 필요하다.
        bw.flush();

        br.close();
        bw.close();
    }

    public static void quickSort(int[] arr, int left, int right) {

        // 재귀 방식으로 양끝의 인덱스를 변화시킬 것이므로, 현재 상태에서의 검사할 끝단 인덱스 저장
        int pl = left;
        int pr = right;
        int x = arr[(pl+pr) / 2];

        do {
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;

            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);


        // left와 right 의 대소관계가 유지될 시에만 퀵 정렬 함수 재귀호출
        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
