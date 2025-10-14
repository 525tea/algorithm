package s07;
import java.io.*;
import java.util.*;

public class S10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String menu = st.nextToken();

            switch (menu) {
                case "push_front": dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back": dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (dq.isEmpty()) sb.append("-1\n");
                    else sb.append(dq.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if (dq.isEmpty()) sb.append("-1\n");
                    else sb.append(dq.pollLast()).append("\n");
                    break;
                case "size": sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front" :
                    if (dq.isEmpty()) sb.append("-1\n");
                    else sb.append(dq.peekFirst()).append("\n");
                    break;
                case "back" :
                    if (dq.isEmpty()) sb.append("-1\n");
                    else sb.append(dq.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}