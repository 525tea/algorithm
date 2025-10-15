package s09;
import java.io.*;
import java.util.*;

public class S11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr); // 오름차순 정렬

        int cnt = 0;      // 현재 숫자의 등장 횟수
        int mxcnt = 0;    // 숫자 등장 횟수의 최댓값
        long mxval = Long.MIN_VALUE; // 최대 등장 수의 값

        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i - 1] == arr[i]) cnt++; // 첫 원소 || 현재 숫자 == 이전 숫자일 때 cnt++
            else { // 새로운 값이 나오면 이전까지의 카운트를 확인하고 max 갱신
                if (cnt > mxcnt) {
                    mxcnt = cnt;
                    mxval = arr[i - 1];
                }
                cnt = 1; // 새로운 값에 대해 카운트 초기화
            }
        }

        // 마지막 숫자 체크 - 카운트가 최대일 경우
        if (cnt > mxcnt) mxval = arr[n - 1];

        System.out.println(mxval);
    }
}
/**
 * 입력 수열을 오름차순으로 정렬한 뒤
 * 연속된 구간의 길이를 센다
 * [1, 2, 2, 2, 3, 3, 3]
 * -> 1, 3, 3
 */