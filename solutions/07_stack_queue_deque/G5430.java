import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine()); // 수의 개수
            String nums = br.readLine();

            ArrayDeque<Integer> dq = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(nums.substring(1, nums.length() - 1), ",");
            for (int i = 0; i < n; i++) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            boolean isError = false;

            for (int i = 0; i < str.length(); i++) {
                char cmd = str.charAt(i);

                switch (cmd) {
                    case 'R':
                        isReversed = !isReversed;
                        break;
                    case 'D':
                        if (dq.isEmpty()) {
                            isError = true;
                            break;
                        }
                        if (!isReversed) dq.pollFirst();
                        else dq.pollLast();
                }
            }

            if (!isError) {
                result.append("[");
                if (!dq.isEmpty()) {
                    if (!isReversed) {
                        while (!dq.isEmpty()) {
                            result.append(dq.pollFirst());
                            if (!dq.isEmpty()) result.append(",");
                        }
                    } else {
                        while (!dq.isEmpty()) {
                            result.append(dq.pollLast());
                            if (!dq.isEmpty()) result.append(",");
                        }
                    }
                }
                result.append("]\n");
            } else {
                result.append("error\n");
            }
        }

        System.out.println(result);
    }
}