package s07;
import java.io.*;
import java.util.*;

public class G2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Deque<int[]> stack = new ArrayDeque<>(); // [idx, height]

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 자신보다 낮은 탑은 수신 불가 → pop
            while (!stack.isEmpty() && stack.peek()[1] <= height) {
                stack.pop();
            }

            // 스택이 비었으면 수신 탑이 존재 x
            // 스택에 원소가 남아있으면 자신보다 높은 탑 = 수신 탑 → peek
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek()[0]).append(" ");
            }

            // 현재 탑을 push
            stack.push(new int[]{i, height});
        }

        System.out.println(sb);
    }
}