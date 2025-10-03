# 14. BFS/DFS


## 백준
| 번호 | 분류 | 제목                                                    | 문제 번호 | 난이도 | 풀이                                           | 코멘트                            | 플래그 |
|----|-----|-------------------------------------------------------|-------|-----|----------------------------------------------|--------------------------------|-|
| 1  | 연습✔ | [그림](https://www.acmicpc.net/problem/1926)            | 1926  |  실버 1  | [풀이](/solutions/14/S1926.java)               | Flood Fill                     | |
| 2  | 연습✔ | [미로 탐색](https://www.acmicpc.net/problem/2178)         | 2178  |  실버 1  | [풀이](/solutions/14/S2178.java)               | 거리 측정, BFS의 핵심은 첫방문이 최단이라는 것   | |
| 3  | 연습✔ | [토마토](https://www.acmicpc.net/problem/7576)           | 7576  |  골드 5  | [풀이](/solutions/14/G7576.java)               | 거리 측정, 시작점이 여러개(멀티 소스 BFS)     | ✅ |
| 4  | 연습✔ | [불!](https://www.acmicpc.net/problem/4179)            | 4179  |  골드 3  | [풀이](/solutions/14/G4179.java)               | 시작점이 두 종류(멀티소스 BFS, 각각 다른 BFS) | ✅ |
| 5  | 연습✔ | [숨바꼭질](https://www.acmicpc.net/problem/1697)          | 1697  |  실버 1   | [풀이](/solutions/14/S1697.java)               | 1차원에서의 BFS                     | ✅ |
| 6  | 기본✔ | [유기농 배추](https://www.acmicpc.net/problem/1012)        | 1012  |  실버 2   | [BFS 풀이](/solutions/14/S1012V1.java) / DFS 풀이 |                                |  |
| 7  | 기본✔ | [적록색약](https://www.acmicpc.net/problem/10026)         | 10026 |  골드 5   | [풀이](/solutions/14/G10026.java) / DFS 풀이     | 선택은 너의 몫 방법은 많다                |  |
| 8  | 기본✔ | [토마토](https://www.acmicpc.net/problem/7569)           | 7569  |  골드 5  |                                              |                                | |
| 9  | 기본✔ | [나이트의 이동](https://www.acmicpc.net/problem/7562)       | 7562  |  실버 1   |                                              |                                |  |
| 10 | 기본✔ | [불](https://www.acmicpc.net/problem/5427)             | 5427  |  골드 5   |                                              |                                |  |
| 11 | 기본 | [영역 구하기](https://www.acmicpc.net/problem/2583)        | 2583  |  실버 1   | [풀이](/solutions/14/S2583.java)               | 행렬, 좌표 정신 차려                   | ✅ |
| 12 | 기본 | [단지번호붙이기](https://www.acmicpc.net/problem/2667)       | 2667  |  실버 1   |                                              |                                |  |
| 13 | 기본 | [스타트링크](https://www.acmicpc.net/problem/5014)         | 5014  |  실버 1   |                                              |                                |  |
| 14 | 기본 | [안전 영역](https://www.acmicpc.net/problem/2468)         | 2468  |  실버 1   |                                              |                                |  |
| 15 | 기본 | [상범 빌딩](https://www.acmicpc.net/problem/6593)         | 6593  |  골드 5   |                                              |                                |  |
| 16 | 응용✔ | [벽 부수고 이동하기](https://www.acmicpc.net/problem/2206)    | 2206  |  골드 3   |                                              |                                |  |
| 17 | 응용✔ | [텀 프로젝트](https://www.acmicpc.net/problem/9466)        | 9466  |   골드 3  |                                              |                                |  |
| 18 | 응용✔ | [빙산](https://www.acmicpc.net/problem/2573)            | 2573  |  골드 4   |                                              |                                |  |
| 19 | 응용✔ | [다리 만들기](https://www.acmicpc.net/problem/2146)        | 2146  |  골드 3   |                                              |                                |  |
| 20 | 응용✔ | [숨바꼭질 3](https://www.acmicpc.net/problem/13549)       | 13549 |  골드 5   |                                              |                                |  |
| 21 | 응용✔ | [말이 되고픈 원숭이](https://www.acmicpc.net/problem/1600)    | 1600  |  골드 3   |                                              |                                |  |
| 22 | 응용 | [숨바꼭질 4](https://www.acmicpc.net/problem/13913)       | 13913 |  골드 4   |                                              |                                |  |
| 23 | 응용 | [벽 부수고 이동하기 2](https://www.acmicpc.net/problem/14442) | 14442 |   골드 3  |                                              |                                |  |
| 24 | 응용 | [벽 부수고 이동하기 3](https://www.acmicpc.net/problem/16933) | 16933 |  골드 1   |                                              |                                |  |
| 25 | 응용 | [확장 게임](https://www.acmicpc.net/problem/16920)        | 16920 |  골드 2   |                                              |                                |  |
| 26 | 응용 | [불켜기](https://www.acmicpc.net/problem/11967)          | 11967 |  골드 2   |                                              |                                |  |
| 27 | 응용 | [숨바꼭질 5](https://www.acmicpc.net/problem/17071)       | 17071 |  플래티넘 5   |                                              |                                |  |
| 28 | 응용 | [열쇠](https://www.acmicpc.net/problem/9328)            | 9328  |  골드 1   |                                              |                                |  |
| 29 | 응용 | [백조의 호수](https://www.acmicpc.net/problem/3197)        | 3197  |  플래티넘 5   |                                              |                                |  |
| 30 | 응용 | [비밀번호 제작](https://www.acmicpc.net/problem/20304)      | 20304 |   플래티넘 5  |                                              |                                |  |
| 31 | 응용 | [뱀과 사다리 게임](https://www.acmicpc.net/problem/16928)    | 16928 |  골드 5  |                                              |                                |  |

<br><br>

## 프로그래머스
### 깊이/너비 우선 탐색(DFS/BFS)
| 번호 | 분류 | 제목                                                                           | 난이도  | 풀이 | 코멘트 | 플래그 |
|----|-----|------------------------------------------------------------------------------|------|---|----|--|
| 1  | 기본 | [타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165)     | lv 2 |  |    |  |
| 2  | 기본 | [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162)      | lv 3 |  |    |  |
| 3  | 기본 | [게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844)  | lv 2 |  |    |  |
| 4  | 기본 | [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163)     | lv 3 |  |    |  |
| 5  | 기본 | [아이템 줍기](https://school.programmers.co.kr/learn/courses/30/lessons/87694)    | lv 3 |  |    |  |
| 6  | 기본 | [여행경로](https://school.programmers.co.kr/learn/courses/30/lessons/43164)      | lv 3 |  |    |  |
| 6  | 기본 | [퍼즐 경로 채우기](https://school.programmers.co.kr/learn/courses/30/lessons/84021) | lv 3 |  |    |  |
