package s09;
import java.io.*;
import java.util.*;

public class S18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 정렬
        Arrays.sort(sorted);

        // 2. 압축 인덱스
        HashMap<Integer, Integer> map = new HashMap<>(); // key 원본 값(origin), value 압축 인덱스
        int idx = 0; // 압축 인덱스의 시작값
        for (int v : sorted) {
            if (!map.containsKey(v)) { // 중복은 인덱스 새로 부여 x
                map.put(v, idx++);
            }
        }

        // 3. 원래 순서대로 인덱스 출력
        for (int v : origin) {
            sb.append(map.get(v)).append(' ');
        }

        System.out.println(sb);
    }
}