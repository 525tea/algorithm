import java.io.*;
import java.util.*;

public class G13549V1 { // 0-1 BFS
    static final int MAX = 100_000;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 시작
        int K = Integer.parseInt(st.nextToken()); // 목표

        // 작은 최적화: N >= K면 뒤로만 가면 됨
        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, INF);
        Deque<Integer> dq = new ArrayDeque<>();

        dist[N] = 0;    // 시작점 초기화
        dq.addFirst(N); // 시작점 삽입

        while (!dq.isEmpty()) {
            int x = dq.pollFirst();

            if (x == K) {           // 목표 정점 도달
                System.out.println(dist[x]);
                return;
            }

            // 0초 이동: x -> 2x
            int nx = x * 2;         // next x
            if (nx <= MAX && dist[nx] > dist[x]) { // 현재 위치(x)를 거쳐 nx에 가는 비용이 기존에 저장되어 있는 비용보다 작으면 최단경로(시간) 업데이트
                dist[nx] = dist[x]; // +0(0초 이동)
                dq.addFirst(nx);    // 0초는 앞에!
            }

            // 1초 이동: x -> x-1
            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);     // 1초는 뒤에!
            }

            // 1초 이동: x -> x+1
            nx = x + 1;
            if (nx <= MAX && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }
    }
}