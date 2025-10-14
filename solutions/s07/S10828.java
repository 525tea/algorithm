package s07;
import java.io.*;
import java.util.*;

public class S10828 { // switch-case문 버전
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();

            switch(menu) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    if (stack.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "top":
                    if (stack.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(stack.peek()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}