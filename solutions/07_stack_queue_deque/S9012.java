import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            String str = br.readLine();
            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else { // ')'
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) isValid = false;
            sb.append(isValid ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}