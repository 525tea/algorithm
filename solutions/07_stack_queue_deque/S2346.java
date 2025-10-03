import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            dq.addLast(new int[]{i + 1, val});
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst(); // 풍선 터뜨리기

            sb.append(cur[0]).append(" "); // 번호 출력
            int move = cur[1]; // 이동할 수

            if (dq.isEmpty()) break; // 종료 조건

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    dq.addLast(dq.pollFirst()); // 오른쪽 이동
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    dq.addFirst(dq.pollLast()); // 왼쪽 이동
                }
            }
        }

        System.out.println(sb);
    }
}