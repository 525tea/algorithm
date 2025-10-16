package s04;

import java.io.*;

public class B1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase(); // 대문자로 통일

        int[] cnt = new int[26]; // A~Z
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'A']++;
        }

        int max = -1;
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                result = (char) (i + 'A');
            } else if (cnt[i] == max) {
                result = '?'; // 중복 최대값 처리
            }
        }

        System.out.println(result);
    }
}