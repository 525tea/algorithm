package s07;
import java.io.*;
import java.util.*;

public class S4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean isBalanced = true;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[' ) {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || (stack.pop() != '(')) { // 단축평가로 isEmpty가 false면 -> stack.pop()은 무조건 발생함. else 필요X
                        isBalanced = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || (stack.pop() != '[')) {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) isBalanced = false; // 모든 과정이 끝났는데 스택이 비지 않았으면 불균형

            sb.append(isBalanced ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }
}