import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> nums = new LinkedList<>();
        for (int i=1; i<=N; i++)  nums.add(i);



        sb.append("<");
        while (nums.size() > 1) {

            //printArr((LinkedList<Integer>) nums);

            int tmp = 0;
            int curr;
            while (tmp < K-1) {
                curr = nums.peek();
                nums.poll();
                nums.add(curr);
                tmp++;
                //System.out.println("curr: " + curr + ", tmp: "+ tmp);

            }

            curr = nums.poll();

            sb.append(curr).append(", ");

        }
        sb.append(nums.poll()).append(">");
        System.out.println(sb);


    }


    private static void printArr(LinkedList<Integer> arr) {
        System.out.println("============");
        for (int num : arr) {
            System.out.println(num);
        }
        System.out.println("============");
    }
}
