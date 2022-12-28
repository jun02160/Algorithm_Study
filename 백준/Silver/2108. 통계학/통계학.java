import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int mid;  // 중앙값
        mid = nums[(N-1)/2];

        System.out.println(getAvg(nums));   // 평균
        System.out.println(nums[(N-1)/2]);  // 중앙값
        System.out.println(getMaxCnt(nums));   // 최빈값
        System.out.println(nums[N-1]-nums[0]);   // 범위(최댓값-최솟값)ß
    }

    private static int getMaxCnt(int[] nums) {
        int mod = nums[0];
        int cnt = 0;
        int max = -1;
        boolean flag = false;

        for (int i=0; i<nums.length-1; i++) {
            if (nums[i+1] == nums[i]) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (max < cnt) {
                max = cnt;
                mod = nums[i];
                flag = true;
            } else if (max == cnt && flag == true) {
                mod = nums[i];
                flag = false;
            }
        }

        return mod;
    }

    public static int getAvg(int[] arr) {
        double sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        return (int)(Math.round(sum / arr.length));
    }

}
