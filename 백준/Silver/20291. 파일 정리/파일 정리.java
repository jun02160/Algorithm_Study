import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String format;
        String filename;
        Map<String, Integer> files = new HashMap<>();
        for (int i=0; i<N; i++) {
            filename = br.readLine();
            format = filename.substring(filename.indexOf('.')+1);
            files.put(format, files.getOrDefault(format, 0)+1);
        }

        // map 자료구조 정렬을 위해 트리맵에 저장
        Map<String, Integer> sortedFile = new TreeMap<>(files);
        for (String key : sortedFile.keySet()) {
            sb.append(key).append(" ").append(sortedFile.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}
