package s04;

import java.io.*;

public class S1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) count++;
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26]; // 등장한 알파벳 체크
        char prev = 0; // 이전 문자 저장

        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            if (cur != prev) { // 새로운 문자일 때
                if (seen[cur - 'a']) return false; // 이전에 이미 등장했으면 그룹 단어 아님
                seen[cur - 'a'] = true; // 처음 등장한 문자로 체크
            }

            prev = cur;
        }
        return true;
    }
}