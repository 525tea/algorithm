package s07;
import java.io.*;
import java.util.*;

public class S3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (T-- > 0) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (stack.isEmpty() || str.charAt(i) != stack.peek()) {
                    stack.push(str.charAt(i));
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}
/**
 * peek()한 것과 같은 문자 -> 기존 탑 pop()
 * 다른 원소면 push()
 * str의 마지막 char까지 진행했는데 스택에 남은거 있으면 false
 */