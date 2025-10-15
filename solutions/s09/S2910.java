package s09;
import java.io.*;
import java.util.*;

public class S2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 전체 수 개수
        int C = Integer.parseInt(st.nextToken()); // 상한값

        st = new StringTokenizer(br.readLine());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        // 1. 빈도 카운트 + 입력 순서 유지
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 2. map.entrySet()을 List로 변환
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // 3. 정렬: 빈도 내림차순, 빈도 같으면 입력 순서 유지
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 4. 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey()).append(" ");
            }
        }

        System.out.println(sb);
    }
}

/**
 * HashMap은 순서 x
 * LinkedHashMap 순서 o
 */