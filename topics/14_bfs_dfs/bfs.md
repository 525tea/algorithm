### ✏️ BFS 개념
- [멀티 소스 BFS 개념](/topics/14_bfs_dfs/multisource_bfs.md)
- [상태 전이 BFS 개념](/topics/14_bfs_dfs/state_bfs.md)
- [백준 #2206 해설, 스레드 모델로 이해하는 BFS의 유형](/solutions/14/G2206.md)
- [0-1 BFS, 다익스트라 + 백준 #13549 해설](/topics/14_bfs_dfs/0-1_bfs.md)
### [📁 BFS 문제 리스트](/topics/14_bfs_dfs/14_bfs_dfs.md)

# BFS (Breadth-First Search)


>BFS는 큐(Queue)를 이용해 가까운 정점부터 차례로 탐색하는 알고리즘이다. <br>
특히 최단거리 보장이라는 강력한 특성이 있어, 많은 문제에서 활용된다.<br>
>- 시간 복잡도: O(R × C) (격자의 경우)
>- 핵심: 큐 + 방문체크 + 거리누적/시간누적

<br>

## BFS 기본 템플릿

### 1. int[] 사용

````java
int[][] board = new int[502][502];
boolean[][] vis = new boolean[502][502];
int[] dx = {1, 0, -1, 0};
int[] dy = {0, 1, 0, -1};

Queue<int[]> q = new ArrayDeque<>();
vis[0][0] = true;
q.offer(new int[]{0, 0});

while (!q.isEmpty()) {
    int[] cur = q.poll();
    for (int dir = 0; dir < 4; dir++) {
        int nx = cur[0] + dx[dir];
        int ny = cur[1] + dy[dir];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (vis[nx][ny] || board[nx][ny] != 1) continue;
        vis[nx][ny] = true;
        q.offer(new int[]{nx, ny});
    }
}
````
<br>

### 2. Pair 클래스 사용

````java
class Pair {
    int x, y;
    Pair(int x, int y) { this.x = x; this.y = y; }
}

Queue<Pair> q = new ArrayDeque<>();
q.offer(new Pair(0,0));

while (!q.isEmpty()) {
    Pair cur = q.poll();
    for (int dir = 0; dir < 4; dir++) {
        int nx = cur.x + dx[dir];
        int ny = cur.y + dy[dir];
        // 조건 검사
        q.offer(new Pair(nx, ny));
    }
}
````
<br>

## BFS 구현 시 주의점
- 시작점의 방문 처리 필수
  - 📌 visited = true 체크는 BFS/DFS 함수 안에서 하는 것으로 통일함(외부와 분리하기 위해)
- 큐에 넣을 때 방문 처리 (중복 방지)
- 범위 벗어나지 않았는지 확인
- BFS는 첫 방문 = 최단거리

<br>

## BFS에서 자주 쓰이는 패턴

### 1. 방문 체크 (visited)
- 무한 루프 방지, 중복 방지

````java
if (visited[nx][ny]) continue;
visited[nx][ny] = true;
````
<br>

### 2. 최단거리 누적 (dist 배열)
- “최소 이동 횟수”, “며칠 걸림” 문제에 필요
````java
dist[nx][ny] = dist[x][y] + 1;
````
<br>

### 3. 레벨 단위 처리 (날짜/시간)
- 하루/시간 단위 전파 문제에 필요
````java
int days = -1;
while (!q.isEmpty()) {
    int size = q.size();
    for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        // 인접 처리
    }
    days++;
}
````
<br>

### 4. 방향 벡터 (dx, dy)
- 반복문으로 간결하게
````java
int[] dx = {1, -1, 0, 0};
int[] dy = {0, 0, 1, -1};
````
<br>

## BFS 유형

### 1. Flood Fill
- 유형 : 연결된 영역 탐색 → 영역 개수, 크기 구하기
- 💡 거리 계산 필요 X, 단순 방문 체크만 필요
- 패턴 : visited 배열로 방문 체크
- 풀이 방법
    1.	이중 for문 돌면서 아직 방문 안 한 영역(board[i][j] == 1 같은 조건)이 있으면 BFS 시작
    2.	BFS 돌려서 연결된 영역 전부 방문 처리
    3.	영역 개수 증가 / 영역 크기 기록
- 대표 문제
  - 그림 (1926): 영역 개수, 최대 넓이
  - 단지번호붙이기 (2667): 단지 개수, 각 단지 크기
  - 유기농 배추 (1012): 지렁이 수
  - 적록색약 (10026): 적록 vs 정상 시야 영역 분리


### 2. 최단거리, 거리 측정
- 유형 : 시작점에서 목표까지 최단거리 구하기, 레벨 단위로 진행
- 💡 각 시작점별로 시작점에서부터 퍼져나가며 각 위치에 최단거리가 저장되는 프로세스
- 💡 BFS는 레벨 순서 → 첫 방문이 무조건 최단거리
- 패턴 : dist 배열에 최단거리 저장, dist[nx][ny] = dist[x][y] + 1
- 풀이 방법
    1.	시작점 큐에 넣고 dist[start] = 0으로 세팅
    2.	BFS 진행하면서 dist[next] = dist[cur] + 1
    3.	목표 지점 도착하면 dist[target] 출력
- 대표 문제:
  - 미로 탐색 (2178): 2D 격자 최단 경로
  - 숨바꼭질 (1697): 1차원 최단 경로
  - 나이트 이동 (7562): 체스판 점프
  - 스타트링크 (5014): 엘리베이터 상하 이동
  - 상범 빌딩 (6593): 3D BFS (층 이동)


### 3. 멀티 소스 BFS(여러 시작점)
[✏️ 멀티 소스 BFS 개념](/topics/14_bfs_dfs/multisource_bfs.md)
- 유형 : 여러 시작점에서 동시에 전파/확산 시작
- 💡 큐를 초기화할 때 모든 시작점을 넣기 → 동시성 보장, 한 번에 BFS 돌리기
- 패턴 : dist 또는 days 배열에 최단거리 저장
- 풀이 방법
    1.	시작점이 여러 개면 전부 큐에 동시에 넣고 시작(멀티소스)
    2.	BFS는 자동으로 “동시에 전파” 효과 발생
    3.	인접한 영역 갱신하면서 거리/날짜 증가
- 대표 문제:
  - 토마토 (7576): 2D 토마토 익기
  - 토마토 3D (7569): 3D 토마토 익기
  - 불 (5427): 불이 퍼지는 시뮬레이션


### 4. 경쟁 BFS (선행 BFS + 후행 BFS)
- 유형 : 위협과 대상이 다른 규칙으로 움직이는 경우, 조건부 이동, 선행 제약이 있는 경우
- 서로 다른 존재가 같은 공간을 두고 경쟁적으로 이동함
- 보통 하나는 “위협” (불, 물 등), 다른 하나는 “플레이어” (사람, 동물 등)
- 💡 BFS를 두 번 돌려서 “위협의 도달 시점(최단거리)“을 계산하고 → 대상 BFS 조건으로 사용
<br> → 선행 BFS(위협) + 후행 BFS(플레이어)
- 풀이 방법
    1.	위협 BFS 먼저 돌리기 → 위협 배열에 각 칸의 도착 시간을 기록
    2.	그 다음 위협 BFS를 조건으로 체크하며 대상 BFS 실행
       <br> - 이동할 때 조건 체크:
           ````java
           if (fireDist[nx][ny] <= dist[x][y] + 1) continue;
           ````
    3. 탈출 조건 만족 시 종료 (테두리 or 목표 지점 등)

- 대표 문제:
  - 불! (4179) : 불 먼저, 지훈 후
  - 탈출 (3055) : 물 먼저, 고슴도치 후
  - 벽 부수고 이동하기 (2206, 14442, 16933) : 방문 배열에 상태(벽 부순 여부 + 좌표) 같이 저장
  - 숨바꼭질 3 (13549) : 순간이동(0초) vs 이동(1초) → 0-1 BFS

<br>

### 5. 상태/제한 BFS
[✏️ 상태/제한 BFS 개념](/topics/14_bfs_dfs/state_bfs.md)
- 하나의 주체가 상태를 가지며 이동 규칙이 달라지는 경우
- 즉, 방문 여부가 단순 좌표가 아니라 (좌표 + 상태)로 정의됨
- 유형

| 문제                | 상태의 의미         | 방문 체크 방식               |
|-------------------|----------------|------------------------|
| 벽 부수고 이동하기(2206)  | 벽을 몇 번 부쉈는가    | visited[x][y][broken]  |
| 말이 되고픈 원숭이 (1600) | 남은 말 점프 횟수     | visited[x][y][k]       |
| 숨바꼭질 3 (13549)    | 0초 이동 or 1초 이동 | 0-1 BFS (Deque 사용)     |
| 열쇠 (9328)         | 열쇠 비트 상태       | visited[x][y][bitmask] |

- 예시
```java
// 3차원 visited or dist
boolean[][][] visited = new boolean[N][M][2];

while (!q.isEmpty()) {
    Node cur = q.poll();
    for (int dir = 0; dir < 4; dir++) {
        int nx = cur.x + dx[dir];
        int ny = cur.y + dy[dir];

        // 벽을 부쉈는지 여부에 따라 조건 달라짐
        if (board[nx][ny] == 1 && cur.broken == 0 && !visited[nx][ny][1]) {
            visited[nx][ny][1] = true;
            q.offer(new Node(nx, ny, 1));
        }
    }
}
```
<br>

**주요 패턴**
- 자료구조 -> visited/dist
- 상태 표현 -> Node(x, y, state) 클래스

<br>

## 6. 그외 가중치 변형형 BFS
0-1 BFS, 다익스트라, 벨만 포드, 플로이드 워셜 등

<br>

## 방문 여부 관리 방식

### 1. visited 배열에 방문 여부 저장
````java
boolean[][] visited = new boolean[N][M];

if (!visited[nx][ny]) {
    visited[nx][ny] = true;
    dist[nx][ny] = dist[x][y] + 1;
    q.offer(new int[]{nx, ny});
}
````
- 장점
  - visited와 dist의 역할이 분리 → 가독성 ↑
  - flood fill 같은 단순 영역 탐색 문제에서도 그대로 재사용 가능 (일관성)
- 단점
  - 메모리 2배 차지 (dist + visited)
- 추천 상황
  - Flood Fill + 거리 측정이 섞여 있는 문제
  - “방문 여부” 자체를 물어보는 문제 (ex. 안전 영역, 영역 개수)


### 2. dist 배열만 사용, -1로 방문 체크

````java
int[][] dist = new int[N][M];
for (int[] row : dist) Arrays.fill(row, -1);

dist[sx][sy] = 0;
while (!q.isEmpty()) {
    int[] cur = q.poll();
    for (int d=0; d<4; d++) {
        int nx = cur[0]+dx[d], ny = cur[1]+dy[d];
        if (nx<0||ny<0||nx>=N||ny>=M) continue;
        if (dist[nx][ny] != -1) continue;  // 이미 방문
        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
        q.offer(new int[]{nx, ny});
    }
}
````
- 장점
  - 방문 여부와 거리 정보를 한 번에 관리 가능 → 코드 간결
  - 무가중치 최단거리 BFS에서는 dist = 방문 배열 대체 가능
- 단점
  - flood fill처럼 “거리 계산이 필요 없는 탐색”에는 적합하지 않음
  - 방문 체크 의도가 살짝 덜 명확 ("dis t== -1 == 미방문" 이라는 걸 알아야 함)
- 추천 상황
  최단거리 구하는 문제

### 3. 플래그(escaped, found)만 쓰는 경우

````java
boolean found = false;
while (!q.isEmpty()) {
    int cur = q.poll();
    if (cur == target) { found = true; break; }
}
System.out.println(found ? dist[target] : "불가능");
````
- 장점
  - 종료 여부를 직관적으로 표시 가능
  - 출력 분기(성공/실패)가 코드에서 명확하게 드러남
- 단점
  - 여전히 방문 여부는 배열(dist/visited)로 체크해야 함 → 플래그만으로는 중복 방문 못 막음
  - BFS의 핵심은 “큐에 중복 삽입 방지”인데, 플래그는 최종 결과 제어용이지 방문 제어용이 아님
- 추천 상황:
  - “탈출/도착 여부”를 출력해야 하는 문제 ex. 6593(상범 빌딩), 5014(스타트링크)
  - BFS 본체는 dist/visited로 돌리고, 출력 분기만 플래그로 처리



### 정리
- Flood Fill → visited[] 별도 저장
- 거리 측정 BFS → dist == -1
- 탈출/성공 여부 문제 → BFS 조건은 dist == -1 로 체크 + 출력은 플래그(또는 return -1)

<br>


## 유형 요약

| 유형            | 패턴         | 배열/변수           | 풀이 포인트                 |
|---------------|------------|-----------------|------------------------|
| Flood Fill    | 영역, 개수, 방문 | visited         | 방문 체크, 영역의 개수 or 크기 세기 |
| 최단거리 BFS      | 최소 이동      | dist            | 첫 방문 = 무조건 최단거리 |
| 멀티소스 BFS  | 동시에 전파     | 멀티 큐 시작, dist   | 시작점 여러개를 큐에 한꺼번에 삽입, BFS를 한번에 돌리기 |
| 경쟁 BFS(선행+후행) | 위협 vs 대상   | fireDist + dist | 위협 BFS(선행) → 대상 BFS(후행) 순서대로

<br>

## 유형별 문제 분류
### **Flood Fill (영역 탐색, 연결 요소)**
- [그림 (1926, 실버1)](https://www.acmicpc.net/problem/1926)
- [유기농 배추 (1012, 실버2)](https://www.acmicpc.net/problem/1012)
- [적록색약 (10026, 골드5)](https://www.acmicpc.net/problem/10026)
- [영역 구하기 (2583, 실버1)](https://www.acmicpc.net/problem/2583)
- [단지번호붙이기 (2667, 실버1)](https://www.acmicpc.net/problem/2667)
- [안전 영역 (2468, 실버1)](https://www.acmicpc.net/problem/2468)
- [빙산 (2573, 골드4)](https://www.acmicpc.net/problem/2573)


### **거리 측정 (1차원/2차원 최단거리)**
- [미로 탐색 (2178, 실버1)](https://www.acmicpc.net/problem/2178)
- [숨바꼭질 (1697, 실버1)](https://www.acmicpc.net/problem/1697)
- [나이트의 이동 (7562, 실버1)](https://www.acmicpc.net/problem/7562)
- [스타트링크 (5014, 실버1)](https://www.acmicpc.net/problem/5014)
- [상범 빌딩 (6593, 골드5)](https://www.acmicpc.net/problem/6593)

### **멀티 소스 BFS (여러 시작점 동시)**
- [토마토 (7576, 골드5)](https://www.acmicpc.net/problem/7576)
- [토마토 3D (7569, 골드5)](https://www.acmicpc.net/problem/7569)

### **경쟁 BFS**
- [불 (5427, 골드5)](https://www.acmicpc.net/problem/5427)
- [불! (4179, 골드3)](https://www.acmicpc.net/problem/4179)
- [탈출 (3055, 골드4)](https://www.acmicpc.net/problem/3055)

### **상태/제한 BFS**
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
