package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S14501V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[20]; // 상담 소요 기간
        int[] p = new int[20]; // 상담 수익
        int[] d = new int[21]; // d[i] = i-1번째 날까지 벌 수 있는 최대 금액

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            // 디폴트 - 일에 상담을 하지 않더라도 전날까지의 최대 수익을 이어받음
            d[i] = Math.max(d[i], d[i - 1]);

            // i번째 날 상담을 진행할 수 있을 경우
            if (i + t[i] - 1 <= n) { // 상담이 퇴사일 전 종료될 때
                d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
            }
        }

        System.out.println(Math.max(d[n], d[n + 1])); // 상담이 n일 시작 & n일 종료되는 경우를 오류 보정. d[n+1] = 퇴사날 아침
    }
}

/**
 * 오늘 상담을 한다/안 한다의 선택
 * i일에 상담을 하면 → i + t[i]일부터 다시 상담 가능
 * i일에 상담을 안 하면 → i + 1일부터 다시 상담 가능
 *
 * 1. dp 테이블 정의
 *    d[i] = i-1번째 날까지 확보한 "얻을 수 있는 최대 수익"
 *
 * 2. 점화식
 *    1) i일에 상담 x -> 전날까지의 수익 넘김 (캐리오버)
 *     -> d[i] = max(d[i], d[i-1])
 *
 *    2) i일에 상담 -> 상담 완료 다음날에 수익 갱신
 *     -> 조건 (i + t[i] - 1 ≤ n) 상담이 끝나는 날짜 <= 퇴사 전날
 *     -> d[i + t[i]] = max(d[i + t[i]], d[i] + p[i]) 기존 값 vs 갱신하려는 값
 *
 * 3. 초기값
 *    d[0] = 0 (근무 시작 전 -> 수익 0)
 *
 * 시간복잡도: O(N)
 * 공간복잡도: O(N)
 */