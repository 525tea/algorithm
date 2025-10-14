package s11;
import java.io.*;
import java.util.*;

public class G1704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recur(N, r, c));
    }

    // 2^N × 2^N 배열에서 (r, c)의 방문 순서를 찾는 함수
    static int recur(int n, int r, int c) { // 목표 r행, c열, 배열의 크기 2^n*2^n
        if (n == 0) return 0; // base condition

        int half = 1 << (n - 1); // (int)Math.pow(2, n - 1) 보다 빠름

        if (r < half && c < half) return recur(n - 1, r, c);
        else if (r < half && c >= half) return half * half + recur(n - 1, r, c - half);
        else if (r >= half && c < half) return 2 * half * half + recur(n - 1, r - half, c);
        else return 3 * half * half + recur(n - 1, r - half, c - half);
    }
}

/**
 * 1. N = 1일 때 시작점이 (0,0), (0,0) -> (0,1) -> (1,0) -> (1,1) 순으로 방문
 * 2. N = k 일 때 -> 2^k * 2^k을 4등분 해서 2^(k-1)*2^(k-1)로 쪼개고 왼위 -> 오위 -> 왼아래 -> 오아래 순으로 방문
 *    N = k+1일 때 -> 2^(k+1) * 2^(k+1)을 4등분 해서 2^k*2^k로 쪼개고 왼위 -> 오위 -> 왼아래 -> 오아래 순으로 방문
 * => 따라서 N에 대해 이 룰이 성립함
 *
 * 배열의 크기는 가로 2^n * 세로 2^n
 *
 * 1. 함수의 정의
 * int recur (int r, int c, int n) {} // 2^n * 2^n 배열에서 (r, c)를 방문하는 순서
 *
 * 2. base condition
 * n = 0일 때 return 0
 *
 * 3. 재귀식
 * 1-왼위, 2-오위, 3-왼아래, 4-오아래 라고 할 때
 * (r, c)가 1번 사각형에 위치 -> return func (n-1, r, c) ;
 * (r, c)가 2번 사각형에 위치 -> return half*half + func(n-1, r, c-half) ;
 * (r, c)가 3번 사각형에 위치 -> return 2*half*half + func(n-1, r-half, c) ;
 * (r, c)가 4번 사각형에 위치 -> return 3*half*half + func(n-1, r-half, c-half);
 */

