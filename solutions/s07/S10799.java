package s07;
import java.io.*;
import java.util.*;

public class S10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else { // ch == ')'
                stack.pop();
                if (str.charAt(i-1) == '(') { // ')' 이전의 문자가 '(' -> 레이저
                    res += stack.size();
                } else { // 쇠막대의 끝
                    res += 1;
                }
            }
        }

        System.out.println(res);
    }
}
/**
 * 1. 열린 괄호 '(' → 무조건 스택에 push (새 막대기 시작)
 * 2. 닫힌 괄호 ')' → 두 가지 경우로 나눔
 * 2-1. 바로 앞 문자가 '(' → 즉, () 레이저 → 스택에서 '(' pop 하고, 현재 스택 크기만큼 조각 추가 (스택에 있는 막대기들이 한 번씩 잘리니까)
 * 2-2. 바로 앞 문자가 ')' → 쇠막대의 끝 → 스택에서 '(' pop 하고, 조각 1개 추가 (마지막 남은 토막)
 */