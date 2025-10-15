package s09;

import java.io.*;
import java.util.*;

public class S5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 숫자만 파싱 -> N
        int n = Integer.parseInt(st.nextToken());

        List<Long> list = new ArrayList<>();
        // 2. 첫 줄에 남은 숫자들 먼저 처리
        while (st.hasMoreTokens()) {
            list.add(Long.parseLong(st.nextToken()));
        }

        // 3. 나머지 줄들 처리, EOF로
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                list.add(Long.parseLong(st.nextToken()));
            }
        }

        // 4. 숫자 뒤집기
        List<Long> reversed = new ArrayList<>();
        for (long num : list) {
            String rev = new StringBuilder(String.valueOf(num)).reverse().toString();
            reversed.add(Long.parseLong(rev));
        }

        // 5. 정렬
        Collections.sort(reversed);

        StringBuilder sb = new StringBuilder();
        for (long val : reversed) sb.append(val).append('\n');
        System.out.print(sb);
    }
}

/**
 * 문자열 편집(?) 단계
 *
 * String.valueOf(num)
 * String 클래스, 숫자 num(long, int double 모두 가능)을 String으로 변환
 *
 * new StringBuilder(str)
 * String str을 가변 버퍼로 감쌈.
 * StringBuilder는 수정 가능한 문자열 버퍼 클래스
 *
 * sb.reverse()
 * StringBuilder 클래스의 내장 메서드, 문자열을 뒤집고 반환
 *
 * sb.toString()
 * 수정이 끝난 가변 문자열 StringBuilder sb를 불변 문자열 String으로 변환
 *
 */