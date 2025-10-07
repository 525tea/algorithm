### [✏️ BFS 개념](/topics/14_bfs_dfs/bfs.md)
- [멀티 소스 BFS 개념](/topics/14_bfs_dfs/multisource_bfs.md)
- [상태 전이 BFS 개념](/topics/14_bfs_dfs/state_bfs.md)
- [백준 #2206 해설, 스레드 모델로 이해하는 BFS의 유형](/solutions/14/G2206.md)
- [0-1 BFS, 다익스트라 + 백준 #13549 해설](/topics/14_bfs_dfs/0-1_bfs.md)

### [📁 BFS 문제 리스트](/topics/14_bfs_dfs/14_bfs_dfs.md)


# 상태/제한 BFS (State-based BFS)

상태(조건)가 추가되어 탐색 차원이 확장되는 BFS

## 1. 개념

제한 BFS는 단순히 (x, y) 좌표만으로 탐색하지 않고, <br>
추가적인 상태(state) 를 함께 저장하면서 탐색하는 BFS이다 <br>

즉, “이 위치에 방문했는가?”가 아니라 <br>
“이 상태로 이 위치에 방문했는가?”를 기준으로 방문 여부를 판단한다

이로 인해 차원이 증가(2D → 3D 이상) 한다 -> 미친! ㅋㅋ

<br>

| 구분 | 	일반 BFS	                      | 제한 BFS                           |
|---|-----------------------------------|----------------------------------|
| 방문 기준 | 	(x, y)                   | 	(x, y, state)                   |
|상태 의미	| 없음	                     | 벽 부쉈는가, 열쇠를 몇 개 가졌는가, 남은 점프 횟수 등 |
|방문 배열	| visited[N][M]	             | visited[N][M][STATE]             |
|탐색 구조	| 2차원	                     | 3차원 이상                           |
|활용 예시	| 단순 이동, 최단거리 | 	조건부 이동, 능력 제한, 상태 변화 포함 문제      |




## 2. BFS 동작 구조

### 1. 상태 노드 정의
```java
class Node {
    int x, y, state;
    Node(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }
}
```

### 2. 3차원 visited 배열
```java
boolean[][][] visited = new boolean[N][M][STATE_MAX];
```
- STATE_MAX는 가능한 상태의 개수
(예: 벽 부쉈는지 0/1 → 2, 말 점프 횟수 0~K → K+1, 열쇠 비트마스크 → 1<<6 등)

### 3. BFS 구현
```java
Queue<Node> q = new ArrayDeque<>();
q.offer(new Node(sx, sy, 0));   // 초기 상태로 시작
visited[sx][sy][0] = true;

while (!q.isEmpty()) {
    Node cur = q.poll();
    int x = cur.x, y = cur.y, s = cur.state;

    for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        int ns = s;

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if (visited[nx][ny][ns]) continue;

        // 상태 변화 로직
        if (board[nx][ny] == 1 && s == 0) {  // 벽인데 아직 안 부쉈음
            ns = 1; // 부쉈다고 표시
        } else if (board[nx][ny] == 1 && s == 1) {
            continue; // 이미 한 번 부쉈으면 불가능
        }

        visited[nx][ny][ns] = true;
        q.offer(new Node(nx, ny, ns));
    }
}
```

## 3. 유형별 패턴 예시

| 문제 유형 |	상태 정의	| 상태 개수	                        | 주요 포인트 |
|---|---|-------------------------------|---|
| 벽 부수고 이동하기 (2206)	| 벽 부쉈는지 여부 (0/1) | 	2	| 벽 만났을 때 한 번만 부술 수 있음 |     
| 말이 되고픈 원숭이 (1600)	| 남은 말 점프 횟수 (0~K)	| K+1	| 일반 이동 + 말 이동 두 가지를 동시에 탐색 |
| 열쇠 (9328)	| 가지고 있는 열쇠의 비트마스크	| 2⁶ (열쇠 6개)	| 소문자 → 열쇠, 대문자 → 문  |
| 숨바꼭질 3 (13549)	| 0초 이동 or 1초 이동	| 2	 | 0-1 BFS로 구현 (Deque 사용) |
| 백조의 호수 (3197)	| 얼음 녹음 여부	| 2	 | 매일 물 확산 BFS + 백조 이동 BFS |


<br>

### 예시 — 벽 부수고 이동하기 (2206)

**핵심: (x, y, broken) 상태로 방문 관리**

```java
import java.io.*;
import java.util.*;

class Node {
    int x, y, broken;
    Node(int x, int y, int broken) {
        this.x = x; this.y = y; this.broken = broken;
    }
}

public class B2206 {
    static int N, M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M][2]; // [x][y][벽부쉈는지]

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        int[][][] dist = new int[N][M][2];

        q.offer(new Node(0, 0, 0));
        visited[0][0][0] = true;
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x, y = cur.y, broken = cur.broken;

            if (x == N - 1 && y == M - 1) return dist[x][y][broken];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이 아닐 경우
                if (board[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    dist[nx][ny][broken] = dist[x][y][broken] + 1;
                    q.offer(new Node(nx, ny, broken));
                }

                // 벽이고 아직 부수지 않았을 경우
                if (board[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    dist[nx][ny][1] = dist[x][y][0] + 1;
                    q.offer(new Node(nx, ny, 1));
                }
            }
        }
        return -1;
    }
}
```


## 4. 핵심 요약

- 차원 확장 :	visited, dist가 (x, y, state) 형태로 확장됨
- 상태 유지 : 이동할 때마다 상태를 함께 전파해야 함
- 중복 방문 방지 : 같은 좌표라도 상태가 다르면 다른 방문으로 취급
- 상태 변화 트리거 : 벽, 열쇠, 점프 등 이벤트가 상태 전환을 일으킴
- 종료 조건 : (x, y, state) → 목적 좌표 도착 시 return dist[x][y][state]

## 5. 한 줄 요약

제한 BFS(State BFS)는 <br>
“좌표 + 상태”를 함께 탐색하는 고차원 BFS, <br>
즉 “조건부 이동”을 구현하는 BFS의 진화형이다 <br>

<br>

## 문제 모음

- [벽 부수고 이동하기 (2206, 골드3)](https://www.acmicpc.net/problem/2206)
- [벽 부수고 이동하기 2 (14442, 골드3)](https://www.acmicpc.net/problem/14442)
- [벽 부수고 이동하기 3 (16933, 골드1)](https://www.acmicpc.net/problem/16933)
- [숨바꼭질 3 (13549, 골드5)](https://www.acmicpc.net/problem/13549)
- [숨바꼭질 4 (13913, 골드4)](https://www.acmicpc.net/problem/13913)
- [숨바꼭질 5 (17071, 플래5)](https://www.acmicpc.net/problem/17071)
- [말이 되고픈 원숭이 (1600, 골드3)](https://www.acmicpc.net/problem/1600)
- [다리 만들기 (2146, 골드3)](https://www.acmicpc.net/problem/2146)
- [확장 게임 (16920, 골드2)](https://www.acmicpc.net/problem/16920)
- [불켜기 (11967, 골드2)](https://www.acmicpc.net/problem/11967)
- [열쇠 (9328, 골드1)](https://www.acmicpc.net/problem/9328)
- [백조의 호수 (3197, 플래5)](https://www.acmicpc.net/problem/3187)
- [비밀번호 제작 (20304, 플래5)](https://www.acmicpc.net/problem/20304)
- [뱀과 사다리 게임 (16928, 골드5)](https://www.acmicpc.net/problem/16928)
- [텀 프로젝트 (9466, 골드3)](https://www.acmicpc.net/problem/9466) ← BFS/DFS (사이클 탐색)
