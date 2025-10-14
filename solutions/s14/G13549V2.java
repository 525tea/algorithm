package s14;
import java.io.*;
import java.util.*;

public class G13549V2 { // 다익스트라
    static final int MAX = 100_000;
    static final int INF = 1_000_000_000;

    // 우선순위 큐에 넣을 상태: (현재 위치 x, 시작점에서 여기까지의 시간 d)
    static class State {
        int x, d;
        State(int x, int d) { this.x = x; this.d = d; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 시작 위치
        int K = Integer.parseInt(st.nextToken()); // 목표 위치

        // N이 K보다 크거나 같으면 뒤로 걷기만 하면 됨 (순간이동은 앞으로만 유용)
        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        // dist[i] = N에서 i까지의 최단시간 (처음엔 무한)
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, INF);
        dist[N] = 0;

        // (시간이 작은 상태가 먼저 나오는) 최소 힙
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.d));
        pq.offer(new State(N, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int x = cur.x, d = cur.d;

            // 낡은 상태면 스킵 (큐에는 같은 정점의 더 나쁜 후보가 남아있을 수 있다)
            if (d != dist[x]) continue;

            // 목표를 현재 최단시간으로 꺼냈다면 그게 정답
            if (x == K) {
                System.out.println(d);
                return;
            }

            // 1) 0초 이동: x -> 2x
            int nx = x * 2;
            if (nx <= MAX && d < dist[nx]) { // nx가 범위 안이고 && 거리(시간)가 누적 최단거리보다 작으면
                dist[nx] = d;                  // 비용 0
                pq.offer(new State(nx, d));
            }

            // 2) 1초 이동: x -> x-1
            nx = x - 1;
            if (nx >= 0 && d + 1 < dist[nx]) {
                dist[nx] = d + 1;
                pq.offer(new State(nx, d + 1));
            }

            // 3) 1초 이동: x -> x+1
            nx = x + 1;
            if (nx <= MAX && d + 1 < dist[nx]) {
                dist[nx] = d + 1;
                pq.offer(new State(nx, d + 1));
            }
        }
    }
}