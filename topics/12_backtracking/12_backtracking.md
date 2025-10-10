### [✏️ 백트래킹 개념](/topics/12_backtracking/backtracking.md)

# 12. 백트래킹

## 백준
| 번호 | 분류 | 제목                                                      | 문제 번호 | 난이도 | 풀이                                | 코멘트 | 플래그 |
|----|----|---------------------------------------------------------|------|-----|-----------------------------------|--|--|
| 1  | 연습 | [N과 M(1)](https://www.acmicpc.net/problem/15649)        | 15649 |  실버 3  | [풀이](/solutions/12/S15649.java)   |  |  |
| 2  | 연습 | [N-Queen](https://www.acmicpc.net/problem/9663)         | 9663  |  골드 4   |                                   |  | ✅ |
| 3  | 연습 | [부분수열의 합](https://www.acmicpc.net/problem/1182)       | 1182  |  실버 2   |                                   |  |  |
| 4  | 기본✔ | [N과 M(2)](https://www.acmicpc.net/problem/15650)        | 15650 |  실버 3   | [풀이](/solutions/12/S15650V2.java) |  |  |
| 5  | 기본✔ | [N과 M(3)](https://www.acmicpc.net/problem/15651)        | 15651 |  실버 3   | [풀이](/solutions/12/S15651.java)   |  |  |
| 6  | 기본✔ | [N과 M(4)](https://www.acmicpc.net/problem/15652)        | 15652 |  실버 3   | [풀이](/solutions/12/S15652.java)   |  |  |
| 7  | 기본✔ | [N과 M(5)](https://www.acmicpc.net/problem/15654)        | 15654 |  실버 3   | [풀이](/solutions/12/S15654.java)   |  |  |
| 8  | 기본✔ | [N과 M(6)](https://www.acmicpc.net/problem/15655)        | 15655 |  실버 3   | [풀이](/solutions/12/S15655.java)   |  |  |
| 9  | 기본✔ | [N과 M(7)](https://www.acmicpc.net/problem/15656)        | 15656 |  실버 3   | [풀이](/solutions/12/S15656.java)   |  |  |
| 10 | 기본✔ | [N과 M(8)](https://www.acmicpc.net/problem/15657)        | 15657 |  실버 3   | [풀이](/solutions/12/S15657.java)   |  |  |
| 11 | 기본✔ | [N과 M(9)](https://www.acmicpc.net/problem/15663)        | 15663 |  실버 2   | [풀이](/solutions/12/S15663.java)   |  | ✅ |
| 12 | 기본✔ | [N과 M(10)](https://www.acmicpc.net/problem/15664)       | 15664 |  실버 2   | [풀이](/solutions/12/S15664.java)   |  | ✅ |
| 13 | 기본✔ | [N과 M(11)](https://www.acmicpc.net/problem/15665)       | 15665 |  실버 2   | [풀이](/solutions/12/S15665.java)   |  | ✅ |
| 14 | 기본✔ | [N과 M(12)](https://www.acmicpc.net/problem/15666)       | 15666 |  실버 2   | [풀이](/solutions/12/S15666.java)   |  | ✅ |
| 15 | 기본✔ | [로또](https://www.acmicpc.net/problem/6603)              | 6603  |  실버 2   |                                   |  |  |
| 16 | 기본 | [연산자 끼워넣기](https://www.acmicpc.net/problem/14888)       | 14888 |  실버 1 |                                   |  |  |
| 17 | 기본 | [스타트와 링크](https://www.acmicpc.net/problem/14889)        | 14889 |  실버 1   |                                   |  |  |
| 18 | 기본 | [암호 만들기](https://www.acmicpc.net/problem/1759)          | 1759  |  골드 5   |                                   |  |  |
| 19 | 응용✔ | [소문난 칠공주](https://www.acmicpc.net/problem/1941)         | 1941  |  골드 3   |                                   |  |  |
| 20 | 응용✔ | [계란으로 계란치기](https://www.acmicpc.net/problem/16987)      | 16987 |  골드 5   |                                   |  |  |
| 21 | 응용 | [Gaaaaaaaaaarden](https://www.acmicpc.net/problem/18809) | 18809 |  골드 1   |                                   |  |  |
| 22 | 응용 | [비숍](https://www.acmicpc.net/problem/1799)              | 1799  |  플래티넘 5   |                                   |  |  |

<br>

### N과 M 시리즈 정리

| 문제    | 이름        | 중복 선택 | 오름차순(비내림차순) | 입력 중복 | 선택 여부(isUsed) 필요 | 재귀 호출 구조                  |
|-------|-----------|---|-------------|-------|------------------|---------------------------|
| 15649 | N과 M (1)  | X | X 순서 상관 있음  | X     | O                | func(k + 1)               |
| 15650 | N과 M (2)  | X | O 오름차순 | X     | O                | func(i + 1, k + 1)        |
| 15651 | N과 M (3)  | O 중복 허용 | X 순서 상관 있음  | X     | X                | func(k + 1)               |
| 15652 | N과 M (4)  | O 중복 허용 | O 오름차순  | X     | X                | func(i, k + 1)            |
| 15654 | N과 M (5)  | X | X 순서 상관 있음  | O     | O 입력 수열에 중복 가능   | func(k + 1) + isUsed      |
| 15655 | N과 M (6)  | X | O 오름차순  | O     | O                | func(i + 1, k + 1)        |
| 15656 | N과 M (7)  | O 중복 허용 | X 순서 상관 있음  | O     | X                | func(k + 1)               |
| 15657 | N과 M (8)  | O 중복 허용 | O 오름차순  | O     | X                | func(i, k + 1)            |
| 15663 | N과 M (9)  | X | X 순서 상관 있음  | O     | O                | func(k + 1) + prev        |
| 15664 | N과 M (10) | X | O 오름차순  | O     | O                | func(i + 1, k + 1) + prev |
| 15665 | N과 M (11) | O 중복 허용  | X 순서 상관 있음  | O     | X                | func(k + 1) + prev        |
| 15666 | N과 M (12) | O 중복 허용  | O 오름차순  | O     | X                | func(i, k + 1) + prev     |
