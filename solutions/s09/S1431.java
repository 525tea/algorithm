package s09;
import java.io.*;
import java.util.*;

public class S1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            // 1. 길이순
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            // 2. 숫자 합 비교
            int sumA = sumDigits(a);
            int sumB = sumDigits(b);
            if (sumA != sumB) {
                return sumA - sumB;
            }

            // 3. 사전순 비교
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s).append("\n");
        System.out.print(sb);
    }

    // 숫자만 골라서 합을 구하는 메서드
    private static int sumDigits(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                sum += c - '0';
            }
        }
        return sum;
    }
}
