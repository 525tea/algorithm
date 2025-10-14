package s12;
import java.io.*;
import java.util.*;

public class S15655 {
    static int N, M;
    static int[] arr; // 선택할 수를 저장하는 수열(temporary)
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list); // 오름차순 정렬

        func(0, 0);
        System.out.println(sb);
    }

    static void func (int start, int k) { // arr[k]를 선택하는 함수
        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < list.size(); i++) {
            arr[k] = list.get(i);
            func(i + 1, k + 1);
        }
    }
}
/**
 * 주어진 N개의 수에서 M개의 수를 오름차순으로 뽑는 수열 => 조합
 */