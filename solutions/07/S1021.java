import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> dq  = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) dq.offerLast(i); // 큐 초기화

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken()); // 타겟

            // val의 위치 찾기
            int idx = 0;
            for (int num : dq) {
                if (num == val) break;
                idx++;
            }

            // 타겟이 큐의 중앙값 왼쪽인지 오른쪽인지 -> 왼쪽 회전이 빠른지, 오른쪽 회전이 빠른지
            if (idx <= dq.size() / 2) {
                // 왼쪽으로 idx번 회전
                for (int j = 0; j < idx; j++) {
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
            } else {
                // 오른쪽으로 size-idx번 회전
                for (int j = 0; j < dq.size() - idx; j++) {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
            }

            dq.pollFirst(); // 맨 앞 원소 추출
        }

        System.out.println(cnt);
    }
}