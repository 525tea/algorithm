# 14. BFS/DFS


## 백준
| 번호 | 분류 | 제목                                                    | 문제 번호 | 난이도 | 풀이 | 코멘트 | 플래그 |
|----|-----|-------------------------------------------------------|-------|-----|------|-|-|
| 1  | 기본 | [그림](https://www.acmicpc.net/problem/1926)            | 1926  |     |      | | |
| 2  | 기본 | [미로 탐색](https://www.acmicpc.net/problem/2178)         | 2178  |     |      | | |
| 3  | 응용 | [토마토](https://www.acmicpc.net/problem/7576)           | 7576  |     |      | | |
| 4  | 기본 | [토마토](https://www.acmicpc.net/problem/7569)           | 7569  |     |      | | |
| 5  | 기본 | [불!](https://www.acmicpc.net/problem/4179)            | 4179  |     |      | |  |
| 6  | 기본 | [숨바꼭질](https://www.acmicpc.net/problem/1697)          | 1697  |     |      | |  |
| 7  | 기본 | [유기농 배추](https://www.acmicpc.net/problem/1012)        | 1012  |     |      | |  |
| 8  | 기본 | [적록색약](https://www.acmicpc.net/problem/10026)         | 10026 |     |      | |  |
| 9  | 기본 | [토마토](https://www.acmicpc.net/problem/7569)           | 7569  |     |      | |  |
| 10 | 기본 | [나이트의 이동](https://www.acmicpc.net/problem/7562)       | 7562  |     |      | |  |
| 11 | 기본 | [불](https://www.acmicpc.net/problem/5427)             | 5427  |     |      | |  |
| 12 | 기본 | [영역 구하기](https://www.acmicpc.net/problem/2583)        | 2583  |     |      | |  |
| 13 | 기본 | [단지번호붙이기](https://www.acmicpc.net/problem/2667)       | 2667  |     |      | |  |
| 14 | 기본 | [스타트링크](https://www.acmicpc.net/problem/5014)         | 5014  |     |      | |  |
| 15 | 기본 | [안전 영역](https://www.acmicpc.net/problem/2468)         | 2468  |     |      | |  |
| 16 | 기본 | [상범 빌딩](https://www.acmicpc.net/problem/6593)         | 6593  |     |      | |  |
| 17 | 응용 | [벽 부수고 이동하기](https://www.acmicpc.net/problem/2206)    | 2206  |     |      | |  |
| 18 | 응용 | [텀 프로젝트](https://www.acmicpc.net/problem/9466)        | 9466  |     |      | |  |
| 19 | 응용 | [빙산](https://www.acmicpc.net/problem/2573)            | 2573  |     |      | |  |
| 20 | 응용 | [다리 만들기](https://www.acmicpc.net/problem/2146)        | 2146  |     |      | |  |
| 21 | 응용 | [숨바꼭질 3](https://www.acmicpc.net/problem/13549)       | 13549 |     |      | |  |
| 22 | 응용 | [말이 되고픈 원숭이](https://www.acmicpc.net/problem/1600)    | 1600  |     |      | |  |
| 23 | 응용 | [숨바꼭질 4](https://www.acmicpc.net/problem/13913)       | 13913 |     |      | |  |
| 24 | 응용 | [벽 부수고 이동하기 2](https://www.acmicpc.net/problem/14442) | 14442 |     |      | |  |
| 25 | 응용 | [벽 부수고 이동하기 3](https://www.acmicpc.net/problem/16933) | 16933 |     |      | |  |
| 26 | 응용 | [확장 게임](https://www.acmicpc.net/problem/16920)        | 16920 |     |      | |  |
| 27 | 응용 | [불켜기](https://www.acmicpc.net/problem/11967)          | 11967 |     |      | |  |
| 28 | 응용 | [숨바꼭질 5](https://www.acmicpc.net/problem/17071)       | 17071 |     |      | |  |
| 29 | 응용 | [열쇠](https://www.acmicpc.net/problem/9328)            | 9328  |     |      | |  |
| 30 | 응용 | [백조의 호수](https://www.acmicpc.net/problem/3197)        | 3197  |     |      |  |  |
| 31 | 응용 | [비밀번호 제작](https://www.acmicpc.net/problem/20304)      | 20304 |     |      |  |  |
| 32 | 응용 | [뱀과 사다리 게임](https://www.acmicpc.net/problem/16928)    | 16928 |     |      |  |  |


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