package s07;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class S1697V1 {
    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        int[] time = new int[MAX + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(time[cur]);
                return;
            }

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int nx : nexts) {
                if (nx < 0 || nx > MAX) continue;
                if (time[nx] != 0) continue;

                time[nx] = time[cur] + 1;
                q.offer(nx);
            }
        }
    }
}
