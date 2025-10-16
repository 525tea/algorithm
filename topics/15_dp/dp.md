

# DP

    작은 부분 문제들의 해를 구하고, 이를 저장했다가 
    
    큰 문제의 해를 구할 때 호출하고, 전체 문제를 해결하는 알고리즘

- 중복되는 부분 문제의 결과를 저장해놓고 호출함으로써 재연산을 피함
- **점화식**(재귀 관계식)을 찾고, 그에 따라 테이블을 채워 답을 구한다
- 테이블의 값을 아래에서부터 채우는 방법(바텀업)
- 위에서부터 재귀 호출을 해서 채우는 방법(탑다운)이 있다


## DP 풀이 절차

1. 테이블 정의하기

    <br> " 어떤 값을 저장할지 "


2. 점화식 찾기

    <br> 점화식을 도출하는 법과 DP 문제를 인지하는 능력은 문제를 많이 풀다보면 향상된다

3. 초기값 정하기

    <br> 피보나치에서 첫번째 항과 두번째 항의 값이 필요하듯이 점화식을 사용해 DP 배열에 값을 채우려면 초기값을 정의해야 한다 

위 3개만 만들면 끝남

## 예제

### 1. BOJ #1463 1로 만들기

[문제 링크](https://www.acmicpc.net/problem/1463)

    문제
    
    X에 대한 아래의 연산 옵션을 사용해서 1을 만드는데 드는 연산 횟수의 최솟값을 구하라
    
    (1) X가 3으로 나누어 떨어지면, 3으로 나눈다
    
    (2) X가 2로 나누어 떨어지면, 2로 나눈다
    
    (3) 1을 뺀다

이 문제는 BFS로 풀 수도 있음 -> 초기값을 1로 두고 *2, *3, +1을 하며 dist 배열을 채운다

**1. 테이블 정의하기**

D[i] = i를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값 

**2. 점화식 찾기**

D[1]부터 D[11]의 값을 모두 알고 있다면

D[12] = ? 어떻게 구할까?

3으로 나누거나 -> D[12] = D[4] + 1

2로 나누거나 -> D[12] = D[6] + 1

1을 빼거나 -> D[12] = D[11] + 1

=> D[12] = min(D[4] + 1, D[6] + 1, D[11] + 1)


이를 일반화하면

D[k] = ?

3으로 나누어 떨어지면 3으로 나누어 구한다 D[k] = D[k/3] + 1
2로 나누어 떨어지면 2로 나누어 구한다 D[k] = D[k/2] + 1
1을 빼서 구한다 D[k] = D[k-1] + 1

위 3가지 방법으로 구한 값 중 최솟값을 선택해 D[k]를 구한다

**3. 초기값 정의하기**

D[1] = 0 

<br>

**구현**

```java
import java.io.*;

public class S1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N + 1]; // 0-indexed
        d[1] = 0; // 초기값 정의

        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + 1;

            if (i % 3 == 0) {
                d[i] = Math.min(dp[i], d[i / 3] + 1);
            }
            if (i % 2 == 0) {
                d[i] = Math.min(dp[i], d[i / 2] + 1);
            }
        }

        System.out.println(d[N]);
    }
}

```

<br>

### 2. BOJ #9095 1, 2, 3 더하기

[문제 링크](https://www.acmicpc.net/problem/9095)

    정수 N을 1, 2, 3의 합으로 나타내는 방법의 수를 구하라

**1. 테이블 정의하기**

D[i] = i를 1, 2, 3의 합으로 나타내는 방법의 수

**2. 점화식 찾기**

D[4] = ?

4 = 

1 + 1 + 1 + 1, 3 + 1, 2 + 1 + 1, 1 + 2 + 1, 

1 + 1 + 2, 2 + 2,

1 + 3

즉, D[4]는

(3을 1, 2, 3의 합으로 나타내는 방법) + 1 => D[4-1]

(2를 1, 2, 3의 합으로 나타내는 방법) + 2 => D[4-2]

(1을 1, 2, 3의 합으로 나타내는 방법) + 3 => D[4-3]

3가지의 합 D[3] + D[2] + D[1]로 표현할 수 있다

따라서 점화식은 다음과 같다

`D[i] = D[i-1] + D[i-2] + D[i-3]`

**3. 초기값 정의하기**

점화식이 `D[i] = D[i-1] + D[i-2] + D[i-3]` 이므로

초기값은 D[1], D[2], D[3]이 주어져야 한다

D[1] = 1, D[2] = 2, D[3] = 4

<br>

**구현**

```java
import java.io.*;

public class S9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= 10; i++) {
            d[i] = d[i-1] + d[i - 2] + d[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(d[N]).append("\n");
        }

        System.out.println(sb);
    }
}

/**
 * dp 배열로 값을 모두 구해놓고 테스트 케이스의 입력값에 따라 꺼내주기(매번 계산x)
 */
```

<br>

### 3. BOJ #2579 계단 오르기

[문제 링크](https://www.acmicpc.net/problem/2579)

    계단의 개수와 각 계단을 밟았을 때 얻을 수 있는 점수가 주어진다
    
    계단 오르는 데는 다음과 같은 규칙이 있다
    
    (1) 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
    
    (2) 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
    
    (3) 마지막 도착 계단은 반드시 밟아야 한다.
    
    계단 아래 시작점부터 계단 꼭대기에 위치한 도착점에 도착할 때까지 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하라


**1. 테이블 정의하기**

D[i] = i번째 계단까지 올라왔을 때 점수 합의 최댓값

-> D[1] = 10, D[2] = 20, .. 이렇게 구해도 

"연속된 세 개의 계단을 모두 밟아서는 안된다"는 제약 조건을 점화식에 반영할 수가 없음

-> 폐기

<br>

D[i][j] = 현재까지 j개의 계단을 연속으로 밟고, i번째 계단까지 올라왔을 때 점수 합의 최댓값
<br> 단, i번째 계단을 반드시 밟아야 함

"현재까지 몇 개의 계단을 연속으로 밟았는지"의 정보를 추가로 받아야 점화식을 세울 수 있기 때문에 1D를 추가해 2차원 배열로 만든다

j -> 'i'번째 계단을 반드시 밟아야 한다는 조건이 있기 때문에 최소 1, 최대 2의 값을 가질 수 있다

즉, i에 대해 D[i][1], D[i][2]를 채워야 함


**2. 점화식 찾기**

(1) D[k][1] = 현재 계단을 포함해 1개의 계단을 연속으로 밟고 k번째 계단에 올라섰을 때의 점수합의 최댓값

-> k-2번째 계단을 밟음 & k-1번째 계단을 안 밟음

`D[k][1] = max(D[k-2][1], D[k-2][2]) + S[k]`

(S[k]는 k번째 계단의 점수)

<br>

(2) D[k][2] = 현재 계단을 포함해 2개의 계단을 연속으로 밟고 k번째 계단에 올라섰을 때의 점수합의 최댓값

-> k-2번째 계단을 안 밟음 & k-1번째 계단을 밟음

-> **즉, k-1번째 계단을 밟을 때는 "연속으로 1개의 계단을 밟은 상태"여야 함**

`D[k][1] = D[k-1][1] + S[k]`

<br>

이 점화식을 사용해 dp 배열을 채우고, 도착점의 점수의 최댓값을 출력하기 위해

max(D[N][1], D[N][2])을 출력하면 된다

<br>

**3. 초기값 정의하기**

D[1][1] = S[1], D[1][2] = 0,

D[2][1] = S[2], D[2][2] = S[1] + S[2]

<br>

**구현**

```java
import java.io.*;

public class S2579V1 { // 2차원 dp 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1]; // 0-indexed 주의
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // N == 1 예외 처리
        if (N == 1) {
            System.out.println(score[1]);
            return;
        }

        int[][] d = new int[N+1][3]; // D[k][1], D[k][2], 0-indexed 주의
        d[1][1] = score[1]; // 초기값 정의
        d[1][2] = 0;
        d[2][1] = score[2];
        d[2][2] = score[1] + score[2];

        for (int i = 3; i <= N; i++) {
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + score[i];
            d[i][2] = d[i-1][1] + score[i];
        }

        System.out.println(Math.max(d[N][1], d[N][2]));
    }
}

```

<br>

### 4. BOJ #1149 RGB 거리

[문제 링크](https://www.acmicpc.net/problem/1149)

    RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
    
    집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 
    
    아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
    
    (1) 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
    (2) N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
    (3) i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

한 마디로 인접한 집끼리는 다른 색이어야 한다는 것


**1. 테이블 정의하기**

D[i] = i번째 집까지 칠했을 때의 최솟값 

-> 이렇게 점화식을 세우면 "인접한 집끼리는 다른 색이어야 한다"는 규칙을 반영할 수가 x

-> dp 테이블에 색상에 관한 정보를 함께 저장한다

<br>

D[i][0] = i번째 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 빨강 

D[i][1] = i번째 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 초록 

D[i][2] = i번째 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 파랑

**2. 점화식 찾기**

D[k][0] = min(D[k-1][1], D[k-1][2]) + R[k]

D[k][1] = min(D[k-1][0], D[k-1][2]) + G[k]

D[k][2] = min(D[k-1][0], D[k-1][1]) + B[k]

**3. 초기값 정의하기**

D[1][0] = R[1]

D[1][1] = G[1]

D[1][2] = B[1]

<br>

**구현**

```java
import java.io.*;
import java.util.StringTokenizer;

public class S1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] R = new int[N + 1];
        int[] G = new int[N + 1];
        int[] B = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[N + 1][3]; // d[i][0], d[i][1], d[i][2]
        d[1][0] = R[1];
        d[1][1] = G[1];
        d[1][2] = B[2];
        for (int i = 1; i <= N; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + R[i]; // i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 빨강
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + G[i]; // i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 초록
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + B[i]; // i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 파랑
        }

        System.out.println(Math.min(d[N][0], Math.min(d[N][1], d[N][2])));
    }
}

```

<br>

### 5. BOJ #11726 2xn 타일링

[문제 링크](https://www.acmicpc.net/problem/11726)

**1. 테이블 정의하기**

D[i] = 2xi 크기의 직사각형을 채우는 방법의 수

**2. 점화식 찾기**

        D[n-1]            D[n-2]
    |██| ... |     |██ ██| ... |
                    -- --
    |██| ... |     |██ ██| ... |

2*1 타일 하나를 쓸 경우 -> 나머지 칸을 채우는 방법의 수는 D[n-1]

1*2 타일 두 개를 쓸 경우 -> 나머지 칸을 채우는 방법의 수는 D[n-2]

따라서 D[i] = D[i-1] + D[i-2]

**3. 초기값 정의하기**

D[1] = 1

D[2] = 2

<br>

**구현**

```java
import java.io.*;

public class S11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 10007;

        int[] d = new int[N + 1];
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= N; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % mod;
        }

        System.out.println(d[N]);
    }
}

```

<br>

### 6. BOJ #11659 구간 합 구하기 4

[문제 링크](https://www.acmicpc.net/problem/11659)

1번째 수부터 i번째 수까지의 합인 dp 배열을 채워 놓으면

i번째 수부터 j번째 수까지의 합을 구할 때 

(1번째 수부터 j번째 수까지의 합) - (1번째 수부터 i-1번째 수까지의 합) 을 출력하면 된다

A[i] + A[i+1] + ... + A[j]

= (A[1] + A[2] + ... + A[j]) - (A[1] + A[2] + ... + A[i-1])

= D[j] - D[i-1]

**1. 테이블 정의하기**

D[i] = 1번째 수부터 i번째 수까지의 합

= A[1] + A[2] + ... + A[i]

**2. 점화식 찾기**

D[i] = D[i-1] + A[i]

**3. 초기값 정의하기**

D[0] = 0


**구현**

생략

<br>

### 7. BOJ #12852 1로 만들기 2 <- 경로 복원

[문제 링크](https://www.acmicpc.net/problem/12852)

    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
    
    (1) X가 3으로 나누어 떨어지면, 3으로 나눈다.
    
    (2) X가 2로 나누어 떨어지면, 2로 나눈다.
    
    (3) 1을 뺀다.
    
    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
    
    첫째 줄에 연산을 하는 횟수의 최솟값을, 둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 
    
    정답이 여러 가지인 경우에는 아무거나 출력한다.



값뿐 아니라 어떤 경로로 도달했는지 출력해야 하는 문제에서는 추가 정보를 저장해야 한다

dp 테이블과 함께 from 또는 prev 배열을 두어 현재 값이 어느 상태에서 유도되었는지를 기록해 두면 마지막에서부터 역추적하여 경로를 복원할 수 있다


<br>

**구현**

```java
import java.io.*;
import java.util.*;

public class G12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];      // 최소 연산 횟수 저장
        int[] pre = new int[n + 1];    // 이전 값 저장 (경로 추적용)

        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;   // 1 빼기
            pre[i] = i - 1;

            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
                pre[i] = i / 2;
            }

            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
                pre[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[n]).append('\n');

        int cur = n;
        while (true) {
            sb.append(cur).append(' ');
            if (cur == 1) break;
            cur = pre[cur];
        }

        System.out.println(sb);
    }
}
```

<br>
