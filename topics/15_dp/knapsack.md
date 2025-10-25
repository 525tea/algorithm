# Knapsack 

    제한된 용량 안에서 물건을 선택해 최대 가치를 얻는 최적화 문제
    
    즉, 용량이 정해진 배낭에 한도에 맞춰 물건을 넣어 최대 가치가 되도록 하는 방법

    조합 최적화 문제의 대표적인 DP 유형이다

    > 핵심은 현재 단계에 "추가할지/ 추가하지 말지"의 선택 중 최대해를 구하는 것

냅색은 크게 두가지 유형으로 분류될 수 있다

- 짐을 쪼갤 수 없는 경우 (0/1 Knapsack Problem) ✔️
    - **물건을 넣거나 or 안 넣거나**
    - **`DP`** 사용

- 짐을 쪼갤 수 있는 경우 (Fraction Knapsack Problem)
    - **`그리디`** 사용
        - 나중에 설명 추가하겠음


### Knapsack 유형 인지하는 힌트

`"제한된 자원(용량·시간·횟수 등) 안에서 선택 조합으로 최대 가치(또는 비용) 구하기"`

=> 바로 Knapsack 소환

Knapsack은 자원(resource)을 소비하는 최적화,

그외 DP 유형은 제약(연속 불가, 인접 불가 등)을 고려한 최적화

- DP : 무게, 시간, 돈, 개수, 용량 등의 제한 + 최대 가치
- 

## 0/1 Knapsack (넣을지/ 안 넣을지)

- 각 물건은 넣을지/ 안 넣을지 2가지 선택지만 있음
- 이전 단계의 최적해를 기반으로, 현재 단계에서 "넣을지/ 안 넣을지"의 선택지 중 더 큰 가치를 선택

### 바텀엄 DP 설계

### 1. DP 정의 

```java
dp[i][w] = i번째 물건까지 고려했을 때, 
           배낭의 용량이 w일 때 얻을 수 있는 최대 가치
```

### 2. 점화식

| 선택               | 점화식 | 설명                             |
|------------------|---|--------------------------------|
| 현재 물건을 넣을 수 없을 때 | `dp[i][w] = dp[i-1][w]` | 이전 단계의 최적해를 계승                 |
| 현재 물건을 넣을 수 있을 때 | `dp[i][w] = max(dp[i-1][w], dp[i-1][w - W[i]] + V[i])` | i번째 물건을 안 넣는 경우 vs 넣는 경우 중 최댓값 |

- W[i] : i번째 물건의 무게
- V[i] : i번째 물건의 가치

`dp[i-1][w - W[i]] + V[i]`

-> i-1번 물건까지 고려해서, w-W[i] 용량을 채웠을 때의 최적해(즉, i번째 물건은 고려안한 최적해) `dp[i-1][w - W[i]]` + i번째 물건의 가치 `V[i]` 

### 3. 초기값

`dp[0][w] = 0`   물건이 하나도 없으면 가치 0

`dp[i][0] = 0`   용량이 0이면 아무것도 못 넣음

### 구현

```java
import java.io.*;
import java.util.*;

public class Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭 용량

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (W[i] > w) dp[i][w] = dp[i - 1][w]; // 못 넣음
                else dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
            }
        }

        System.out.println(dp[N][K]);
    }
}

/**
 * 0/1 Knapsack (DP)
 *
 * 1. dp 테이블
 *    dp[i][w] = i번째 물건까지 고려했을 때, 용량 w에서의 최대 가치
 *
 * 2. 점화식
 *    - W[i] > w → dp[i][w] = dp[i-1][w]
 *    - W[i] ≤ w → dp[i][w] = max(dp[i-1][w], dp[i-1][w - W[i]] + V[i])
 *
 * 3. 초기값
 *    dp[0][w] = 0, dp[i][0] = 0
 *
 * 시간복잡도: O(N*K)
 * 공간복잡도: O(N*K)
 */
```

### 시간복잡도 

$O(N*K)$ (N=물건 개수, K=배낭 용량)

<br>

### 1차원 DP (공간 최적화 ver)

이전 행만 참조하도록 해서 1D를 줄임

단, 뒤에서부터 갱신해야 함(덮어쓰기 방지)

```java
int[] dp = new int[K + 1];
for (int i = 1; i <= N; i++) {
    for (int w = K; w >= W[i]; w--) {
        dp[w] = Math.max(dp[w], dp[w - W[i]] + V[i]);
    }
}
System.out.println(dp[K]);
```

### 탑다운 DP 버전

```java
static int knapsack(int i, int w) {
    if (i == 0 || w == 0) return 0;
    if (dp[i][w] != -1) return dp[i][w];

    if (W[i] > w) dp[i][w] = knapsack(i - 1, w);
    else dp[i][w] = Math.max(knapsack(i - 1, w),
                             knapsack(i - 1, w - W[i]) + V[i]);
    return dp[i][w];
}
```

구현으로는 바텀업이 효율적이다



### Knapsack 문제

| 문제 번호 | 문제명                                              | 유형                 |
|-------|--------------------------------------------------|--------------------|
| 12865 | [평범한 배낭](https://www.acmicpc.net/problem/12865)  | 기본 0/1 Knapsack    |
| 11052 | [카드 구매하기](https://www.acmicpc.net/problem/11052) | 중복 가능 Knapsack     |
| 1106  | [호텔](https://www.acmicpc.net/problem/1006)       | 최소 비용 Knapsack     |
| 2293 | [동전 1](https://www.acmicpc.net/problem/2293) | 중복 가능 Knapsack     |
| 2294 | [동전 2](https://www.acmicpc.net/problem/2294) | 중복 가능 Knapsack     |
| 5557 | [1학년](https://www.acmicpc.net/problem/5557) | 수식 기반, 변형 Knapsack |
| 17845 | [수강 과목](https://www.acmicpc.net/problem/17845) | 가치 & 시간 Knapsack |
