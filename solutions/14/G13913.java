import java.io.*;
import java.util.*;

public class G13913 {
    static final int MAX = 100_000;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        int[] prev = new int[MAX + 1];  // 경로 복원을 위한 배열, 이전 노드를 저장
        Arrays.fill(dist, INF);

        Queue<Integer> q = new ArrayDeque<>();

        dist[N] = 0; // 시작점
        prev[N] = -1; // 시작점은 이전 노드 없음
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) break; // 도착하면 멈춤

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int nx : nexts) {
                if (nx < 0 || nx > MAX) continue;
                if (dist[nx] > dist[cur] + 1) { // 미방문 -> INF, 이미 방문했어도 새 경로가 더 짧으면 갱신
                    dist[nx] = dist[cur] + 1;
                    prev[nx] = cur; // nx의 이전 노드로 cur를 저장
                    q.offer(nx);
                }
            }
        }

        // 최단 거리 출력
        System.out.println(dist[K]);

        // 경로 복원 (역추적)
        List<Integer> path = new ArrayList<>();
        for (int i = K; i != -1; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        // 경로 출력
        for (int x : path) System.out.print(x + " ");
    }
}
/**
 * 정점 K까지 온 path
 * K → prev[K] → prev[prev[K]] … 이렇게 역추적
 */